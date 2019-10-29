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


// 추천곡을 적어주세요! url
@Controller
@RequestMapping("/recommendation/**")
public class LikeController {

	private static final Logger log = LoggerFactory.getLogger(LikeController.class);

	// LikeService 객체를 의존성 주입시킨다.
	@Autowired
	private LikeService likeService;
		
	private Integer LIKE_COUNT=0;
	
	//post likeList 는 추천 카운트  이다 .  
	//한개 ip 당 하나만 가능하다
	// 게시판 bno 에 해당하는 추천  목록을 가져온다.
	@PostMapping("likeList")
	public String likeList(LikeVO  likeVO, Model model) throws Exception{				
		if(exitLike(likeVO)) { //exitLike() 메서를 통해 현재 유저의 아이피가 추천을 했는지 여부를 체크한다.
			model.addAttribute("likecount", LIKE_COUNT); // likec
			model.addAttribute("likeClientIP", "exist");
		}

		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/recommendation/likeList.jsp  로 이동 처리한다.
		return "mss/recommendation/likeList";
	}
	
	// /recommendation/likeUpdate 처리를 한다. 
	@PostMapping("likeUpdate")
	public void likeUpdate(LikeVO  likeVO, HttpServletResponse response) throws Exception{		
		PrintWriter out =response.getWriter();				
		try {		
			likeVO.setLip(IpAddress.getIP());
			
			if(exitLike(likeVO)) {	 //exitLike() 메서를 통해 현재 유저의 아이피가 추천을 했는지 여부를 체크한다.	
				//존재 하면 삭제
				// 클릭시 기존 것이 존재 하면 삭제
				//delete from tbl_like where bno=#{bno} and lip=#{lip}
				likeService.delete(likeVO);			
			}else {
				//클릭시 기존 것이
				//존재하지 않으면 삽입  
				// insert into tbl_like  (bno, lip) VALUES ( #{bno}, #{lip} )
				likeService.insert(likeVO);
			}
			
			//ajax 로 성공시 SUCCESS 를 반환 시킨다.
			out.print("SUCCESS");
		}catch (Exception e) {			
			// 실패시 FAIL 을 반환 시킨다.
			out.print("FAIL");
		}
	}
	
	
	//클라이언트 현재 접속자 - 게시글 추천에 존재 확인 하는 메서드이다.
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
