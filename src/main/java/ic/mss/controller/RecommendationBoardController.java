package ic.mss.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.BoardVO;
import ic.mss.model.vo.UserVO;
import ic.mss.service.RecommendationBoardService;
import ic.mss.util.config.IpAddress;
import ic.mss.util.config.PageMakerAndSearch;

@Controller
@RequestMapping("/recommendation/**")
public class RecommendationBoardController {
	
	private static final Logger log = LoggerFactory.getLogger(RecommendationBoardController.class);

	@Autowired
	private RecommendationBoardService recommendationBoardService;

	
	//등록폼 이동
	@GetMapping("write")
	public String registeForm(BoardVO boardVO) throws Exception{		
		return "mss/recommendation/write";
	}
	
	//등록
	@PostMapping("write")
	public String registe(@Valid BoardVO boardVO, BindingResult bindingResult, Model model) throws Exception{		
		//log.info(" write  {} " , boardVO.toString());		
		if(bindingResult.hasErrors()) {
			return "mss/recommendation/write";	
		}

		if(boardVO.getImgcnt()==null) {
			boardVO.setImgcnt(0);
		}
		
		boardVO.setIp(IpAddress.getIP());
		
		boardVO.setting();
		
		recommendationBoardService.register(boardVO);		
		return "redirect:list";
	}
	
	
	//목록
	@GetMapping("list")
	public String getReadList(PageMakerAndSearch pageMaker, BoardVO boardVO, Model model) throws Exception{
		
		Integer totalCount=recommendationBoardService.boardTotalCount(pageMaker);
		
		pageMaker.setTotalCount(totalCount);
		pageMaker.setPerPageNum(25);
		pageMaker.setDisplayPageNum(3);
		
		List<BoardVO> list=recommendationBoardService.getReadList(pageMaker);
		
		String pagination=pageMaker.bootStrapPagingSearchHTML4("/recommendation/list");
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		//추천 1개 이상 최신 데이터  5개 항목 가져오기
		List<BoardVO> likeList=recommendationBoardService.getReadLikeList();
		model.addAttribute("likeList", likeList);
		
		return "mss/recommendation/list";
	}
	
	
	//읽기
	@GetMapping("read/{bno}")
	public String getRead(@PathVariable("bno") Integer bno, BoardVO boardVO, Model model) throws Exception{		
		model.addAttribute("boardVO" ,recommendationBoardService.getRead(boardVO));		
		//조회수 증가 처리
		recommendationBoardService.viewcntAdd(boardVO);
	
		return "mss/recommendation/read";
	}
	
	
	@GetMapping("inlist")
	public String inlist(PageMakerAndSearch pageMaker, BoardVO boardVO, Model model) throws Exception{
		
		Integer totalCount=recommendationBoardService.boardTotalCount(pageMaker);
		
		pageMaker.setTotalCount(totalCount);
		pageMaker.setPerPageNum(25);
		
		List<BoardVO> list=recommendationBoardService.getReadList(pageMaker);
		
		String pagination=pageMaker.bootStrapPagingSearchHTML2("/recommendation/list");
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		//추천 1개 이상 최신 데이터  5개 항목 가져오기
		List<BoardVO> likeList=recommendationBoardService.getReadLikeList();
		model.addAttribute("likeList", likeList);
		
		return "mss/recommendation/inlist";
	}
	
	
	
	
	//비밀번호로 작성한 게시판 업데이트 폼  - 비밀번호로 이동시
	@PostMapping("boardEdit")
	public String boardEdit(BoardVO boardVO, HttpServletResponse response, Model model) throws Exception{
		//비밀번호 재 확인	
		log.info("작성한 게시판 업데이트 폼  {}" , boardVO.toString());
		if(recommendationBoardService.passwordConfirm(boardVO)==1) {
			//업데이트 폼으로 이동
			BoardVO getBoard=recommendationBoardService.getRead(boardVO);
			model.addAttribute("boardVO", getBoard);			
			return "mss/recommendation/update";
		}else {			
			return "redirect:/";
		}	
	}
	
	
	//로그인 한 유저 작성한 게시판 - 업데이트 폼 이동
	@PostMapping("boardEditDirect")
	public String boardEditDirect(BoardVO boardVO, HttpSession session, Model model) throws Exception{
		//보안 체크
		BoardVO getBoard=	recommendationBoardService.getRead(boardVO);
		UserVO userVO=(UserVO)session.getAttribute("USER");
		if(userVO.getUserID().equals(getBoard.getUserID())) {
			model.addAttribute("boardVO", getBoard);
			return "mss/recommendation/update";	
		}			
		return "redirect:/";
	}
	

	
	//로그인 한 유저 작성한 게시판 - 삭제처리
	@PostMapping("removeDirect")
	public void removeDirect(BoardVO boardVO, HttpSession session, HttpServletResponse response) throws Exception{		
		PrintWriter out =response.getWriter();
		
		//보안 체크
		BoardVO boardCheck=	recommendationBoardService.getRead(boardVO);
		UserVO userVO=(UserVO)session.getAttribute("USER");
		if(userVO.getUserID().equals(boardCheck.getUserID())) {	
			recommendationBoardService.remove(boardVO);			
			out.print("SUCCESS");
		}else {
			out.print("fail");
		}
	}

	//비밀번호 입력으로 작성한 게시판 - 삭제처리
	@PostMapping("remove")
	public void remove(BoardVO boardVO, HttpSession session, HttpServletResponse response) throws Exception{
		PrintWriter out =response.getWriter();		
		if(recommendationBoardService.passwordConfirm(boardVO)==1) {
			recommendationBoardService.remove(boardVO);			
			out.print("SUCCESS");
		}else {
			out.print("fail");
		}
	}
	
	
	
	//변경
	@PostMapping("update")
	public String boardUpdate(BoardVO boardVO) throws Exception{
		log.info(" update   {} ", boardVO.toString());
		
		boardVO.setting();
		
		recommendationBoardService.boardUpdate(boardVO);		
		return "redirect:read/"+boardVO.getBno();
	}
	
	
	
	//비밀번호 확인
	@PostMapping("passwordConfirm")
	public void passwordConfirm(BoardVO boardVO, HttpServletResponse response) throws Exception{				
		PrintWriter out=response.getWriter();
		out.print(recommendationBoardService.passwordConfirm(boardVO));
	}
	
	

	//베스트 추천글
	//읽기
	@GetMapping("besetLike")
	public String besetLike( Model model) throws Exception{		
		//추천 1개 이상 최신 데이터  5개 항목 가져오기
		List<BoardVO> likeList=recommendationBoardService.getReadLikeList();
		model.addAttribute("likeList", likeList);
	
		return "mss/besetLike";
	}
	


	
}
