package ic.mss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/music/**")
public class MusicSiteControll {

	
	@RequestMapping("site")
	public String musicHome() {
		
		return "mss/musicsite";
	}
	
}
