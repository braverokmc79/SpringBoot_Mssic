package ic.mss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomController {

	@RequestMapping(value="/")
	public String index(HttpSession session) {	
			
		return "mss/index";		
	}
}
