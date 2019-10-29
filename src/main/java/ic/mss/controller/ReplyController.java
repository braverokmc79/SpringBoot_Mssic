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

	// ReplyService 객체를  의존성 주입시킨다.
	@Autowired
	private ReplyService service;

	// setting
	private ReplyVO setting(ReplyVO replyVO, HttpSession session) {		        

		UserVO user=(UserVO)session.getAttribute("USER");		
		
		if(user!=null) {
			//로그인 한 유저가 댓글을 작성한 경우
		  replyVO.setUserID(user.getUserID());	
		  replyVO.setRnickname(user.getNickname());		  
		}
		
		//댓글 등록 시 아이피 처리
		replyVO.setRip(IpAddress.getIP());
        return replyVO;
	}
	

	// /recommendation/replies/create  post 방식 호출 시  답변 등록 처리
	//등록
	@RequestMapping(value="create", method=RequestMethod.POST)
	public ResponseEntity<String> register(ReplyVO replyVO, HttpSession session){
		ResponseEntity<String> entity=null;	
		try {
			
			ReplyVO vo=setting(replyVO, session);
			//log.info("등록 :   {} ", vo.toString());
			
			replyVO.setting();	
			//DB에 저장한다.
			service.createBoard(vo);
			// 응답처리로 SUCCESS 반환하며  헤더에 ok를 반환 한다.
			entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			// 응답처리로 에러 메시지를  반환하며  헤더에 BAD_REQUEST를 반환 한다.
			entity =new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}				
		return entity;
	}
	
	//    /recommendation/replies/all/{bno}   get post 식 호출시 
	//해당게시판 답변 목록 전체 불러오기
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public String list(@PathVariable("bno") Integer bno,  
			Model model) throws Exception{	
		  //log.info("해당게시판 답변 목록 {}", service.listAllReplyVO(bno));
		List<ReplyVO>  replyList =service.listAllReplyVO(bno);
		for(ReplyVO vo :replyList) {
			// 역슬러 n  을 <br> html 처리를 대체에 다음 칸 처리를 한다.
			String str =vo.getContent().replaceAll("\n", "<br>");						
			vo.setContent(str);
		}

		model.addAttribute("replyList", replyList);
		
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/recommendation/replyList.jsp  로 이동 처리한다.			
		return "mss/recommendation/replyList";
	}
	
	
	

			
	//  /recommendation/replies/{rno}   get post 식 호출시 
	//로그인한 유저 삭제 처리
	@RequestMapping(value="/{rno}", method=RequestMethod.POST)
	public ResponseEntity<String> remove(@PathVariable("rno") Integer rno, HttpSession session) throws Exception{
		ResponseEntity<String> entity=null;
		
		UserVO user=(UserVO)session.getAttribute("USER");		
		//체크 삭제 대상과 작성자와 일치 확인
		ReplyVO replyVO=service.getRnoInfo(rno);
		
		if(user.getUserID().equals(replyVO.getUserID())){
			
			try {
				//DB 에 삭제 처리한다
				service.deleteBoard(rno);
				// 응답 처리로 SUCCESS 를 반환 하면 헤더에 OK 
				entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				// 응답 처리로 에러 메시지를 반환 하면 헤더에 BAD_REQUEST 
				entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			// 응답 처리로 FAIL를 반환 하면 헤더에 BAD_REQUEST 
		}else entity=new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		
		return entity;
	}
	
	
	//  /recommendation/removePassowrd/{rno}   get post 식 호출시 
	@RequestMapping(value="removePassowrd/{rno}", method=RequestMethod.POST)
	public ResponseEntity<String> removePassowrd(@PathVariable("rno") Integer rno, ReplyVO replyVO,
			HttpSession session) throws Exception{
		ResponseEntity<String> entity=null;
						
		//체크 삭제 대상과 작성자와 일치 확인
		Integer resultCount=service.getPasowrdConfirm(replyVO);
		
		if(resultCount==1){			
			try {
				service.removePassowrd(replyVO);
				// 응답 처리로 SUCCESS 를 반환 하면 헤더에 OK 
				entity=new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}catch(Exception e) {
				e.printStackTrace();
				// 응답 처리로 에러 메시지를 반환 하면 헤더에 BAD_REQUEST 
				entity=new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			// 응답 처리로 FAIL를 반환 하면 헤더에 BAD_REQUEST 
		}else entity=new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		
		return entity;
	}
	
	
	
	
	
	
	
	
}
