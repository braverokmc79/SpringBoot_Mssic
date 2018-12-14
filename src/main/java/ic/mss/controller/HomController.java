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

	
	@Autowired
	private RecommendationBoardService recommendationBoardService;
	
	
	@Autowired
	private AudioService audioService;
	
	@RequestMapping(value="/")
	public String index(Model model, HttpSession session) throws Exception {	
		
		List<AudioVO> audioList=audioService.getStreamingList();
		
		
		List<BoardVO> bestViewList =recommendationBoardService.bestViewList();		
		List<BoardVO> bestCommentList =recommendationBoardService.bestCommentList();		
		model.addAttribute("bestViewList", bestViewList);
		model.addAttribute("bestCommentList", bestCommentList);
		model.addAttribute("audioList", audioList);
		
		return "mss/index";		
	}
}
