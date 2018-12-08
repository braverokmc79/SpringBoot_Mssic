package ic.mss.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ic.mss.model.vo.UserVO;
import ic.mss.service.UserService;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/login")
	public String loginform() 
			throws Exception{
		return  "mss/login";
	}
	
		
	
	@PostMapping("/login")
	public void loginAction(UserVO userVO, HttpServletResponse response,  HttpSession session) throws Exception{
		PrintWriter out=response.getWriter();		
		try {

			//아이디 존재 확인
			Integer  userIdCheckCount =userService.userGet(userVO);
			if(userIdCheckCount==0) {
				//1.해당 아이디가 없습니다. -0 번
				out.print(0);
			}else {
				userVO=userService.userLoginIdPw(userVO);
				if(userVO==null || StringUtils.isEmpty(userVO)) {
					//2.로그인 실패. 비밀번호가 일치하지 않습니다. - 1 번
					out.print(1);	
				}else {
					//3.로그인 성공 10번
					//세션 생성
					session.setAttribute("USER", userVO);
					out.print(10);					
				}
			}
			
		}catch(Exception e) {
			//기타 오류
			out.print(2);
		}
		
	}
	

	
	
}

