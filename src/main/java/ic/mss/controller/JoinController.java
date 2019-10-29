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
	
	
	// UserService 객체를  의존성 주입시킨다.
	@Autowired
	private UserService userService;
	
	//  /join/signup 호출신 회원 가입폼으로 이동 시킨다.
	@GetMapping("signup")
	public String joinForm(UserVO userVO) throws Exception{			
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/signup.jsp  로 이동 처리한다.
		return "mss/signup";
	}
	
	// /join/signUp url 호출로 post 방식 호출시
	//유저 가입	
	@PostMapping("signUp")
	public void joinAction(UserVO userVO,  Model model, HttpServletResponse response) 
				throws Exception{
		//log.info("회원 가입 : {}", userVO.toString());
		//ajax 로 호출 될시  처리 답변으로 PrintWriter 를 이용한다.
		PrintWriter out=response.getWriter();
		try{			
			//id 주소를 가져온다.
			userVO.setIp(IpAddress.getIP());
			// DB에 생성 한다.
			userService.userCreate(userVO);
			
			//성공시 ajax 에 SUCCESS 를 반환 시킨다.
			out.print("SUCCESS");			
		}catch(Exception e) {
			// 실패시 ajax 에 fail 를 반환 시킨다.
			out.print("fail");
		}
		
	}
	
	
	// /join/checkUserId url 의 ajax post 방식 호출시
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
