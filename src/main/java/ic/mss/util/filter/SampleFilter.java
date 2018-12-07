package ic.mss.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최준호 (braverokmc79@gmail.com)
     
   @업데이트일 2018. 11. 16. 오후 8:38:42
	
 */
public class SampleFilter implements Filter{

	
	private static final Logger log = LoggerFactory.getLogger(SampleFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		log.info("\n------------------------------");
		HttpServletRequest req =(HttpServletRequest)request;
		log.info(req.getRequestURI());
		log.info("---------------------------------\n");
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	
}
