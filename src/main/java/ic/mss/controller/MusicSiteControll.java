package ic.mss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import ic.mss.model.vo.AudioVO;
import ic.mss.service.AudioService;

@Controller
@RequestMapping("/music/**")
public class MusicSiteControll {
	
	private static final Logger log = LoggerFactory.getLogger(MusicSiteControll.class);	
	

	
	@RequestMapping("site")
	public String musicHome() throws Exception{
		return "mss/musicsite";
	}
	

	
	
	
}
