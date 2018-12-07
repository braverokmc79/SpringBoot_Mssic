package ic.mss.util.interceptor;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

public class LoginSessionCheck {

	
	public static boolean check(HttpSession session) {		
		if(StringUtils.isEmpty(session.getAttribute("USER"))) {
			return true;
		}		
		return false;
	}
	
	
	
}
