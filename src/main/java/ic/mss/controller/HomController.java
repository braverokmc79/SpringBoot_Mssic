package ic.mss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.AudioVO;
import ic.mss.model.vo.BoardVO;
import ic.mss.service.AudioService;
import ic.mss.service.RecommendationBoardService;

@Controller
public class HomController {

	// RecommendationBoardService 객체를 의존성 주입시킨다.
	@Autowired
	private RecommendationBoardService recommendationBoardService;
	
	// AudioService 의 객체를 의존성 주입시킨다.
	@Autowired
	private AudioService audioService;
	
	// / 루트 url 호출시 다음을 실행한다.
	@RequestMapping(value="/")
	public String index(Model model, HttpSession session) throws Exception {	
		
		// tbl_audio 의 재생 목록중  show 컬럼의 yes 만 가져온다.
		List<AudioVO> audioList=audioService.getStreamingList();
		
		
		// 많이 조회한 게시판 5개의 목록을  가져온다.
		List<BoardVO> bestViewList =recommendationBoardService.bestViewList();		
		
		// 많이 댓글을 달은 5개의 목록을 가져온다
		List<BoardVO> bestCommentList =recommendationBoardService.bestCommentList();		
		model.addAttribute("bestViewList", bestViewList); // bestViewList의 이름으로 bestViewList 넣는다
		model.addAttribute("bestCommentList", bestCommentList); // bestCommentList 이름으로  bestCommentList를 넣는다.
		model.addAttribute("audioList", audioList); // audioList 이름으로 audioList 를 넣는다.
		
		//  src/main/webapp/WEB-INF/views/mss 의 
	    // mss/index.jsp 로 이동 처리한다.
		return "mss/index";		
	}
}
