package ic.mss.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.LikeVO;
import ic.mss.service.LikeService;
import ic.mss.util.config.IpAddress;

@Controller
@RequestMapping("/recommendation/**")
public class LikeController {

	
	private static final Logger log = LoggerFactory.getLogger(LikeController.class);

	
	@Autowired
	private LikeService likeService;
	
	
	private Integer LIKE_COUNT=0;
	
	
	
	@PostMapping("likeList")
	public String likeList(LikeVO  likeVO, Model model) throws Exception{				
		if(exitLike(likeVO)) {
			model.addAttribute("likecount", LIKE_COUNT);
			model.addAttribute("likeClientIP", "exist");
		}
		return "mss/recommendation/likeList";
	}
	
	
	@PostMapping("likeUpdate")
	public void likeUpdate(LikeVO  likeVO, HttpServletResponse response) throws Exception{		
		PrintWriter out =response.getWriter();				
		try {		
			likeVO.setLip(IpAddress.getIP());
			
			if(exitLike(likeVO)) {				
				//존재 하면 삭제
				likeService.delete(likeVO);			
			}else {
				//존재하지 않으면 삽입
				likeService.insert(likeVO);
			}
			out.print("SUCCESS");
		}catch (Exception e) {
			out.print("FAIL");
		}
	}
	
	
	//클라이언트 현재 접속자 - 게시글 추천에 존재 확인 
	private boolean exitLike(LikeVO  likeVO)  throws Exception {
		List<LikeVO> likeList=likeService.likeList(likeVO);
		String clientIP=IpAddress.getIP();		
		if(likeList!=null) {
			LIKE_COUNT=likeList.size();			
			for(LikeVO vo : likeList) {
				//현재 접속자 아이피 확인		
				if(vo.getLip().equals(clientIP)) {					
					return true;
				}
			}							
		}	
		return false;
	}
	
}
