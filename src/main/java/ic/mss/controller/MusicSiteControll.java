package ic.mss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music/**")
public class MusicSiteControll {
	
	private static final Logger log = LoggerFactory.getLogger(MusicSiteControll.class);	
	

	// /music/site url 호출시 get , post 상관없이 처리한다.
	@RequestMapping("site")
	public String musicHome() throws Exception{
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/musicsite.jsp  로 이동 처리한다.
		return "mss/musicsite";
	}
	

	
	
	
}
