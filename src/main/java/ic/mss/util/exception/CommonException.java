package ic.mss.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

//400 , 404, 414, 500  제외한 나머지 에러는  @ControllerAdvice   처리하기로 한다.

@ControllerAdvice
public class CommonException {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonException.class);

	// 개발자 버전 - 에러메시지 상세 확인 error_datail 페이지로 이동
	// public static final String DEFAULT_ERROR_VIEW = "error/error_developer";
	
    // 일반 - 에러메시지로 error 페이지로 이동
    public static final String DEFAULT_ERROR_VIEW = "error/error";
    
    @ExceptionHandler(Exception.class)
    public String commonErrorMessage(Exception e) {
        logger.error("@ExceptionHandler(Exception.class) --  {}", e.getStackTrace());
     
        return DEFAULT_ERROR_VIEW;
    }
    
    
    @ExceptionHandler(RuntimeException.class)
    private ModelAndView handleRuntimeExceptionErrorMessage(RuntimeException e) {
         
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        modelAndView.addObject("exception", e);
        logger.error("@ExceptionHandler(RuntimeException.class) --  {}", e.getStackTrace());
         
        return modelAndView;
    }
 
    
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String methodAnnotationException(Throwable e, HandlerMethod handlerMethod) {
        ResponseBody methodAnnotation = handlerMethod.getMethodAnnotation(ResponseBody.class);          
        if (methodAnnotation != null) {
            // @ResponseBody  어노테이션이 있으면 이렇게 처리 하시오 . - ajax 
            logger.error(" @ResponseBody 에서 일어난 에러");   
        }
         
        logger.error("methodAnnotation() , {}" , e.getStackTrace());   
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        modelAndView.addObject("exception", e);
         
      return DEFAULT_ERROR_VIEW;
    }
    
    
    private String errorMessge(StackTraceElement[] stes){
        StringBuffer buffer =new StringBuffer();
        buffer.append("\n\n");
        buffer.append("★ ★ ★     에러 메시지 시작 ★★★  \n\n");
         
        for(int i=0; i<stes.length; i++){
            if(i==0){
                buffer.append("★ 에러 시작 클래스 이름 className : " + stes[i].getClassName()+"\n" );                        
                buffer.append("★ 에러 시작 메서드 이름(methodName) : " + stes[i].getMethodName() + ", line : " + stes[i].getLineNumber() +"\n\n");
            }else{
                buffer.append("STACKTRACE - className : " + stes[i].getClassName() + ", 메서드 이름(methodName) : "
                          + stes[i].getMethodName() + ", line : " + stes[i].getLineNumber() +"\n");
            }
        }
         
        return buffer.toString();
    }
    
}
