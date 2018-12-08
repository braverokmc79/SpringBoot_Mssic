package ic.mss.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.UserVO;
import ic.mss.service.UserService;
import ic.mss.util.config.IpAddress;

@Controller
@RequestMapping("/join/**")
public class JoinController {
	private static final Logger log = LoggerFactory.getLogger(JoinController.class);
	
	@Autowired
	private UserService userService;
	
	//회원 가입폼으로 이동
	@GetMapping("signup")
	public String joinForm(UserVO userVO) throws Exception{		
		return "mss/signup";
	}
	
	
	//유저 가입	
	@PostMapping("signUp")
	public void joinAction(UserVO userVO,  Model model, HttpServletResponse response) 
				throws Exception{
		//log.info("회원 가입 : {}", userVO.toString());		
		PrintWriter out=response.getWriter();
		try{			
			userVO.setIp(IpAddress.getIP());
			userService.userCreate(userVO);
			out.print("SUCCESS");			
		}catch(Exception e) {
			out.print("fail");
		}
		
	}
	
	
	
	//유저 아이디 중복 체크	
	@PostMapping("checkUserId")
	public void checkUserId(UserVO userVO, HttpServletResponse response) throws Exception {		
		//아이디 중복 없음  1  중복 있음 0
		Integer  userIdCheckCount =userService.userGet(userVO);		
		//log.info(userVO.toString()+" 아이디 중복 체크 :  {} ", userIdCheckCount );		
		PrintWriter out=response.getWriter();
		out.print(userIdCheckCount);				
	}
	
	//유저 닉네임 중복 체크
	@PostMapping("checkUserNickname")
	public void checkUserNickname(UserVO userVO, HttpServletResponse response) throws Exception {				
		Integer  userGetNickname =userService.userGetNickname(userVO);		
		//log.info(userVO.toString()+" 아이디 중복 체크 :  {} ", userGetNickname );		
		PrintWriter out=response.getWriter();
		out.print(userGetNickname);				
	}
	
	
	
	
	
}
