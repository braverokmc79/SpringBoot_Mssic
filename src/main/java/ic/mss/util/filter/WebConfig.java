package ic.mss.util.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

//XSS 보안  필터

//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	
	//참조 
	//https://github.com/naver/lucy-xss-servlet-filter
	
	private static final Logger log = LoggerFactory.getLogger(WebConfig.class);
	
   // @Bean
    public FilterRegistrationBean getFilterRegistrationBean1(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //log.info(" \n\n\n  xss 필터   \n\n\n");
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean2(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(1);
       // registrationBean.addUrlPatterns("*.do", "*.go");    //filter를 거칠 url patterns
        registrationBean.addUrlPatterns("*.do", "*.go" ,"/member/*");    //filter를 거칠 url patterns        
        return registrationBean;
    }    
    
    
}