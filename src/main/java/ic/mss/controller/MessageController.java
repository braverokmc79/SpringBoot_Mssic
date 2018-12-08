package ic.mss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.MessageVO;
import ic.mss.model.vo.UserVO;
import ic.mss.service.MessageService;

//@Controller
//@RequestMapping("/users/message/**")
public class MessageController {

	private static final Logger log = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private MessageService messageService;
	
	
	@RequestMapping("{grade}")
	public String messageList(@PathVariable(value="grade") String grade, MessageVO messageVO, 
			HttpSession session, Model model) throws Exception {
		log.info("grade : {}", grade );
		
		//grade 값이 정상일 경우 실행 
		if(grade.equals("fatal") || grade.equals("error") || 
				grade.equals("warn") || grade.equals("info") || grade.equals("all")){
		
								
			messageVO.setGrade(grade);
			
			
			if(grade.equals("all")) {
				List<MessageVO>  messageList =messageService.messageAllList();
				model.addAttribute("messageList", messageList);				
			}else {				
				model.addAttribute("messageList", messageService.messageGetList(messageVO));		
			}	
			
			model.addAttribute("grade", grade);
			return "message";
		}
		
		
		
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
}
