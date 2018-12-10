package ic.mss.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ic.mss.model.vo.ReplyVO;
import ic.mss.model.vo.UserVO;
import ic.mss.service.ReplyService;
import ic.mss.util.config.IpAddress;

@Controller
@RequestMapping("/recommendation/replies/**")
public class ReplyController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ReplyController.class);

	
	@Autowired
	private ReplyService service;

	// 
	private ReplyVO setting(ReplyVO replyVO, HttpSession session) {		        

		UserVO user=(UserVO)session.getAttribute("USER");		
		
		if(user!=null) {
			//로그인 한 유저가 댓글을 작성한 경우
		  replyVO.setUserID(user.getUserID());	
		  replyVO.setRnickname(user.getNickname());		  
		}
		replyVO.setRip(IpAddress.getIP());
        return replyVO;
	}
	

	
	//등록
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ResponseEntity<String> register(ReplyVO replyVO, HttpSession session){
		ResponseEntity<String> entity=null;	
		try {
			
			ReplyVO vo=setting(replyVO, session);
			log.info("등록 :   {} ", vo.toString());
			
			replyVO.setting();		
			service.createBoard(vo);
			
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			entity =new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}				
		return entity;
	}
	
	//해당게시판 답변 목록 전체 불러오기
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public String list(@PathVariable("bno") Integer bno,  
			Model model) throws Exception{	
		  //log.info("해당게시판 답변 목록 {}", service.listAllReplyVO(bno));
		List<ReplyVO>  replyList =service.listAllReplyVO(bno);
		for(ReplyVO vo :replyList) {
			String str =vo.getContent().replaceAll("\n", "<br>");						
			vo.setContent(str);
		}

		model.addAttribute("replyList", replyList);
		return "mss/recommendation/replyList";
	}
	
	
	

			
	
	//로그인한 유저 삭제 처리
	@RequestMapping(value="/{rno}", method=RequestMethod.POST)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno, HttpSession session) throws Exception{
		ResponseEntity<String> entity=null;
		
		UserVO user=(UserVO)session.getAttribute("USER");		
		//체크 삭제 대상과 작성자와 일치 확인
		ReplyVO replyVO=service.getRnoInfo(rno);
		
		if(user.getUserID().equals(replyVO.getUserID())){
			
			try {
				service.deleteBoard(rno);
				entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			
		}else entity=new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		
		return entity;
	}
	
	
	@RequestMapping(value="removePassowrd/{rno}", method=RequestMethod.POST)
	public ResponseEntity<String> removePassowrd(@PathVariable("rno") Integer rno, ReplyVO replyVO,
			HttpSession session) throws Exception{
		ResponseEntity<String> entity=null;
						
		//체크 삭제 대상과 작성자와 일치 확인
		Integer resultCount=service.getPasowrdConfirm(replyVO);
		
		if(resultCount==1){			
			try {
				service.removePassowrd(replyVO);
				entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			
		}else entity=new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		
		return entity;
	}
	
	
	
	
	
	
	
	
}
