package ic.mss.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최준호 (braverokmc79@gmail.com)
     
   @업데이트일 2018. 11. 16. 오후 8:38:42
	
 */

//@Component
//@Order(1)
public class RequestResponseLoggingFilter implements Filter {
   
    private static final Logger  log = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter( ServletRequest request,ServletResponse response, FilterChain chain) throws IOException, ServletException {
  
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
      
        log.info("Logging 요청 (Request)  {} : {}", req.getMethod(), req.getRequestURI());
          
        chain.doFilter(request, response);
        log.info("Logging 응답 ( Response) :{}",   res.getContentType());
                   
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 

}
