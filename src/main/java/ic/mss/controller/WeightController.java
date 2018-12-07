package ic.mss.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ic.mss.model.vo.ScoreVO;
import ic.mss.model.vo.UserVO;
import ic.mss.service.ScoreService;

@Controller
@RequestMapping("/users/weight/**")
public class WeightController {

	
	private static final Logger log = LoggerFactory.getLogger(WeightController.class);
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping("{type}")
	public String weightForm(@PathVariable(value="type") String type, ScoreVO scoreVO,   Model model , HttpSession session ,
			 @RequestParam(required=false) String message) throws Exception{
		log.info("type - {}" , type );
				
		//타입 체크 후 정상일 경우 실행
		if(type.equals("zabbix") || type.equals("checkserver") || type.equals("crash")) {
			model.addAttribute("type", type);
						
			UserVO userVO =(UserVO)session.getAttribute("USER");
			
			//스코어 객체
			scoreVO.setUserId(userVO.getId());
			scoreVO.setType(type);
			ScoreVO getScoreObject=scoreService.scoreGet(scoreVO);
				
			if(getScoreObject!=null) model.addAttribute("score", getScoreObject);	
													
			if(message!=null && message.equals("ok")) model.addAttribute("message", "ok");
		
			return "weight";
		}
		
		//타입 오류일 경우 / 이동
		return "/";
	}
	
	
	@PostMapping("")
	public String weightAction(ScoreVO scoreVO ,  
				Model model, HttpSession session)  throws Exception{
		
		UserVO userVO =(UserVO)session.getAttribute("USER");
		
		//스코어
		scoreVO.setUserId(userVO.getId());
		scoreVO.setType(scoreVO.getType());
		ScoreVO getScoreObject=scoreService.scoreGet(scoreVO);
		
		if(getScoreObject==null) {
			log.info("\n\n\n socre 신규 삽입");
			scoreService.scoreCreate(scoreVO);
		}else {
			log.info("\n\n\n socre 업데이트");			
			scoreService.scoreUpdate(scoreVO);
		}
		
		model.addAttribute("message", "설정 되었습니다.");
				
		return "redirect:/users/weight/"+scoreVO.getType()+"?message=ok";
	}
	
		
}
