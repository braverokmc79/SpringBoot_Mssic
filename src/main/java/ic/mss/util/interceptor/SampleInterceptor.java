package ic.mss.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SampleInterceptor extends HandlerInterceptorAdapter{

	
	private static final Logger log = LoggerFactory.getLogger(SampleInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("============== SAMPLE INTERCEPTOR ===============");		
		//return super.preHandle(request, response, handler);
		return true;
	}
	
	
	
	
}
