package ic.mss.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.AlarmVO;
import ic.mss.model.vo.UserVO;
import ic.mss.service.AlarmService;

//@Controller
//@RequestMapping("/users/alarm/**")
public class AlarmController {

	private static final Logger log = LoggerFactory.getLogger(AlarmController.class);
	
	@Autowired
	private AlarmService alarmService;
	
	
	@GetMapping("")
	public String home(AlarmVO alarmVO, HttpSession session, Model model) throws Exception{
    	UserVO  user=(UserVO)session.getAttribute("USER");
    	
    	log.info("\n\n\n user     {}" , user.getId() );
    	
    	
    	alarmVO.setUserId(user.getId());
    	
    	AlarmVO alarm=alarmService.getIdData(alarmVO);		
    	model.addAttribute("alarm", alarm);
    	
		return "alarm";
	}

	
	
    @PostMapping("ajax")
	public void ajax(AlarmVO alarmVO, Model model, HttpServletResponse response, HttpSession session) throws Exception{
		    
    	UserVO  user=(UserVO)session.getAttribute("USER");
    	alarmVO.setUserId(user.getId());
    	    	
    	log.info(" alarmVO  :   {}" , alarmVO.toString() );
    	    	
    	//user id 의 기존 데이터가 있으면 업데이트 처음 데이터 인지 확인
    	AlarmVO getAlarm=alarmService.getIdData(alarmVO);
    	
    	if(getAlarm==null) {
    		//1. 데이터 삽입 후 업데이트
    		alarmService.insertAlarm(alarmVO);    	
    	}
    	
    	//2. 데이터 업데이트
		alarmService.updateAlarm(alarmVO);
    	
    	
    	PrintWriter out =response.getWriter();
    	out.println("success");    	
	}

    
    
    
    
    
    
}
