package ic.mss.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ic.mss.model.vo.LoginUserVO;
import ic.mss.model.vo.UserVO;
import ic.mss.service.UserService;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String loginform(@RequestParam(required=false) String congratulations, LoginUserVO loginUserVO ,Model model) 
			throws Exception{
		if(congratulations!=null) {
			if(congratulations.equals("ok")) {
				model.addAttribute("congratulations", "회원 가입을 축하합니다.");
			}
		}
		return  "login";
	}
	
	
	@PostMapping("/login")
	public String loginAction(@Valid LoginUserVO loginUserVO, BindingResult bindingResult,
			 Model model,	HttpSession session)  throws Exception{
		
		//에러체크
		if(bindingResult.hasErrors()) {			
			return  "login";
		}
				
		UserVO userVO =new UserVO();
		userVO.setId(loginUserVO.getId());
		userVO.setPw(loginUserVO.getPw());
		
		UserVO user=userService.userPwdConfirm(userVO);
		if(user==null) {
			model.addAttribute("errorMessage" , "아이디와 비밀번호가 일치 하지 않습니다.");
			return "login";
		}
		
		//세션 생성		
		session.setAttribute("USER", userService.userGet(userVO));
		
		return  "redirect:/users";
	}
	

	
	
}

