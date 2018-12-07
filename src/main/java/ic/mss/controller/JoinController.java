package ic.mss.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ic.mss.model.vo.UserVO;
import ic.mss.service.UserService;

@Controller
public class JoinController {
	private static final Logger log = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/join")
	public String joinForm(UserVO userVO) throws Exception{		
		return "join";
	}
	
	
	
	@PostMapping("/join")
	public String joinAction(@Valid UserVO userVO, BindingResult bindingResult, Model model, HttpSession session) 
				throws Exception{
				
		if(bindingResult.hasErrors()) {
			return "join";
		}

		//1.비밀번호와 비밀번호 확인 체크
		if(!userVO.pwCompare()) {
			model.addAttribute("errorMessage" , "비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "join";
		}
		
		//2.아이디 중복 체크
		UserVO  userIdCheck =userService.userGet(userVO);
		if(userIdCheck!=null) {
			model.addAttribute("errorMessage" , "이미 등록된 아이디 입니다.");
			return "join";
		}		
		
		
		//3.이메일 중복 체크
		UserVO  userEmailCheck =userService.userGetEmail(userVO);
		if(userEmailCheck!=null) {
			model.addAttribute("errorMessage" , "이미 등록된 이메일 입니다.");
			return "join";
		}
				
		//4. 회원 등록
		userService.userCreate(userVO);
		
		//가입 환영 메시지
		return "redirect:/login?congratulations=ok";
	}
	
	
	
	
	
	
	
}
