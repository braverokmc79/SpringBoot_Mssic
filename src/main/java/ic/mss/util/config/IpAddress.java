package ic.mss.util.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class IpAddress {

	
	public static String getIP() {
		 HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
	     String ip = req.getHeader("X-FORWARDED-FOR");
	     if (ip == null) ip = req.getRemoteAddr();	       
	     return ip;   
	}
	
}
