package ic.mss.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	// RecommendationBoardService 객체를  의존성 주입시킨다.
	@Autowired
	private RecommendationBoardService recommendationBoardService;

	
	//recommendation/write   get 방식 호출시 등록폼 이동
	@GetMapping("write")
	public String registeForm(BoardVO boardVO) throws Exception{	
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/recommendation/write.jsp  로 이동 처리한다.
		return "mss/recommendation/write";
	}
	
	//recommendation/write   post 방식 호출시 등록처리
	//등록
	@PostMapping("write")
	public String registe(@Valid BoardVO boardVO, BindingResult bindingResult, Model model) throws Exception{		
		//log.info(" write  {} " , boardVO.toString());	
		// 
		if(bindingResult.hasErrors()) {
			//  src/main/webapp/WEB-INF/views/mss 의 
			// mss/recommendation/write.jsp  로 이동 처리한다.
			return "mss/recommendation/write";	
		}

		if(boardVO.getImgcnt()==null) {
			//imgcnt  값이 null 일 경우 기본 0 으로  imgcnt 필드에 저장 시킨다.
			boardVO.setImgcnt(0);
		}
		
		// IpAddress.getIP() 를 통해 ip 를 저장 시킨다.
		boardVO.setIp(IpAddress.getIP());
		//	boardVO.setting() 의 메서드를 통해 xss 제목과 닉네임에서  스크립트 제거 처리를 한다.
		boardVO.setting();
		//DB에 저장 시킨다.
		recommendationBoardService.register(boardVO);	
		
		//리다이텍터로  recommendation/list url 로 이동 시킨다.
		return "redirect:list";
	}
	
	//recommendation/list   get 방식 호출시 목록 처리
	//목록
	@GetMapping("list")
	public String getReadList(PageMakerAndSearch pageMaker, 
			HttpServletRequest request,
			BoardVO boardVO, Model model) throws Exception{
		//전체 tbl_board 갯수를 구한다.
		Integer totalCount=recommendationBoardService.boardTotalCount(pageMaker);
		
		// pageMaker 에  전체 갯수를 저장후 계산 처리한다.
		pageMaker.setTotalCount(totalCount);
		// 25개의 목록이 출력이 나오도록 처리한다.
		pageMaker.setPerPageNum(25);
		// 페이징은 3개씩 보이도록 처리한다.
		pageMaker.setDisplayPageNum(3);
		
		List<BoardVO> list=recommendationBoardService.getReadList(pageMaker);
		
		String pagination=pageMaker.bootStrapPagingSearchHTML4(request.getContextPath()+"/recommendation/list");
		
		model.addAttribute("pagination", pagination); // 페이징 String  담는다
		model.addAttribute("pageMaker", pageMaker);   //페이지 메이커 객체를 담는다.
		model.addAttribute("totalCount", totalCount); // 전체 개수를 구한 totalcount 를 담는다.
		model.addAttribute("list", list);  // 목록처리한 List<BoardVO> 객체를  담는다.
		
		
		//추천 1개 이상 최신 데이터  5개 항목 가져오기
		List<BoardVO> likeList=recommendationBoardService.getReadLikeList();
		model.addAttribute("likeList", likeList);
		
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/recommendation/list.jsp  로 이동 처리한다.
		return "mss/recommendation/list";
	}
	
	//recommendation/read   get 방식 호출시 상세보기 처리
	//{bno} 의  @PathVariable("bno") Integer bno 통해 해당 게시판 번호를 가져온다.
	//읽기
	@GetMapping("read/{bno}")
	public String getRead(@PathVariable("bno") Integer bno, BoardVO boardVO, Model model) throws Exception{		
		model.addAttribute("boardVO" ,recommendationBoardService.getRead(boardVO));		
		//조회수 증가 처리
		recommendationBoardService.viewcntAdd(boardVO);
	
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/recommendation/read.jsp  로 이동 처리한다.
		return "mss/recommendation/read";
	}
	
	
	// recommendation/inlist  get 방식으로  호출시
	// 게시글 상세보기 하단에  게시글을 리스트로  보여줄 것이다.
	@GetMapping("inlist")
	public String inlist(PageMakerAndSearch pageMaker,HttpServletRequest request, BoardVO boardVO, Model model) throws Exception{
		
		Integer totalCount=recommendationBoardService.boardTotalCount(pageMaker);
		
		pageMaker.setTotalCount(totalCount);
		pageMaker.setPerPageNum(25);
		
		List<BoardVO> list=recommendationBoardService.getReadList(pageMaker);
		
		String pagination=pageMaker.bootStrapPagingSearchHTML2(request.getContextPath()+"/recommendation/list");
		
		model.addAttribute("pagination", pagination); // 페이징 String  담는다
		model.addAttribute("pageMaker", pageMaker);   //페이지 메이커 객체를 담는다.
		model.addAttribute("totalCount", totalCount); // 전체 개수를 구한 totalcount 를 담는다.
		model.addAttribute("list", list);  // 목록처리한 List<BoardVO> 객체를  담는다.
		
		//추천 1개 이상 최신 데이터  5개 항목 가져오기
		List<BoardVO> likeList=recommendationBoardService.getReadLikeList();
		model.addAttribute("likeList", likeList);
		
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/recommendation/inlist.jsp  로 이동 처리한다.		
		return "mss/recommendation/inlist";
	}
	
	
	
	// recommendation/boardEdit  post 방식으로  호출시
	//비밀번호로 작성한 게시판 업데이트 폼으로 이동한다.  - 비밀번호로 이동시
	@PostMapping("boardEdit")
	public String boardEdit(BoardVO boardVO, HttpServletResponse response, Model model) throws Exception{
		//비밀번호 재 확인	
		log.info("작성한 게시판 업데이트 폼  {}" , boardVO.toString());
		if(recommendationBoardService.passwordConfirm(boardVO)==1) {
			//업데이트 폼으로 이동
			BoardVO getBoard=recommendationBoardService.getRead(boardVO);
			model.addAttribute("boardVO", getBoard);
			
			//  src/main/webapp/WEB-INF/views/mss 의 
			// mss/recommendation/update.jsp  로 이동 처리한다.				
			return "mss/recommendation/update";
		}else {	
			
			//이상이 있을 경우 리다이렉터러 / 이동시킨다
			return "redirect:/";
		}	
	}
	
	// recommendation/boardEditDirect  호출시
	//로그인 한 유저 작성한 게시판 - 업데이트 폼 이동
	@PostMapping("boardEditDirect")
	public String boardEditDirect(BoardVO boardVO, HttpSession session, Model model) throws Exception{
		//보안 체크
		BoardVO getBoard=	recommendationBoardService.getRead(boardVO);
		UserVO userVO=(UserVO)session.getAttribute("USER");
		if(userVO.getUserID().equals(getBoard.getUserID())) {
			model.addAttribute("boardVO", getBoard);
			
			//  src/main/webapp/WEB-INF/views/mss 의 
			// mss/recommendation/update.jsp  로 이동 처리한다.					
			return "mss/recommendation/update";	
		}	
		//리다이텍터로  / url 로 이동 시킨다.		
		return "redirect:/";
	}
	

	// recommendation/removeDirect  post 방식 호출시
	//로그인 한 유저 작성한 게시판 - 삭제처리
	@PostMapping("removeDirect")
	public void removeDirect(BoardVO boardVO, HttpSession session, HttpServletResponse response) throws Exception{		
		PrintWriter out =response.getWriter();
		
		//다시 한번 서버에서  보안 체크를 한다  tbl_board 에서 해당 번호로 정보를 가져온다
		BoardVO boardCheck=	recommendationBoardService.getRead(boardVO);
		//세션에 담긴 유저 객체를 정보를  UserVO 에 넣는다.
		UserVO userVO=(UserVO)session.getAttribute("USER");
		// 세션에 담김 객체와  해당글을 작성한 유저가 동일인지 체크를 한다.
		if(userVO.getUserID().equals(boardCheck.getUserID())) {	
			//동일할 경우 DB 에서 제거 처리를 한다
			recommendationBoardService.remove(boardVO);			
			// 에러가 없을 경우 ajax 에 SUCCESS 를 반환 시킨다.
			out.print("SUCCESS");
		}else {
			// 동일하지 않거나 에러가 있을시 fail 을 ajax 에 반환 시켜 준다.
			out.print("fail");
		}
	}

	
	// recommendation/remove  post 방식 호출시
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
	
	
	
	// recommendation/update  post 방식 호출시
	//변경
	@PostMapping("update")
	public String boardUpdate(BoardVO boardVO) throws Exception{
		log.info(" update   {} ", boardVO.toString());	
		//	boardVO.setting() 의 메서드를 통해 xss 제목과 닉네임에서  스크립트 제거 처리를 한다.
		boardVO.setting();		
		recommendationBoardService.boardUpdate(boardVO);		
		return "redirect:read/"+boardVO.getBno();
	}
	
	
	// recommendation/passwordConfirm  post 방식 호출시
	//비밀번호 확인 ajax 처리시 
	@PostMapping("passwordConfirm")
	public void passwordConfirm(BoardVO boardVO, HttpServletResponse response) throws Exception{				
		PrintWriter out=response.getWriter();
		//select count(*) from tbl_board where bno=#{bno} and pw=#{pw}
		//카운터 갯수를 반환 시킨다.
		out.print(recommendationBoardService.passwordConfirm(boardVO));
	}
	
	

	// recommendation/besetLike  get 방식 호출시
	//베스트 추천글
	//읽기
	@GetMapping("besetLike")
	public String besetLike( Model model) throws Exception{		
		//추천 1개 이상 최신 데이터  5개 항목 가져오기
		List<BoardVO> likeList=recommendationBoardService.getReadLikeList();
		model.addAttribute("likeList", likeList);
	
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/besetLike.jsp  로 이동 처리한다.	
		return "mss/besetLike";
	}
	


	
}
