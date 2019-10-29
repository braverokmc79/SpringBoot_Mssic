package ic.mss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.ReplyMapper;
import ic.mss.model.vo.ReplyVO;
import ic.mss.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	private static final Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);

	// ReplyMapper 객체를  의존성 주입시킨다.
	@Autowired
	private ReplyMapper replyMapper;


	//등록 처리 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public void createBoard(ReplyVO replyVO) throws Exception {
		replyMapper.createBoard(replyVO);				
	}

	//하나의 데이터 가져오기 읽기 처리 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public ReplyVO readBoard(Integer bno) throws Exception {		
		return replyMapper.readBoard(bno) ;
	}

	// 업데이트 처리 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public void updateBoard(ReplyVO replyVO) throws Exception {
		replyMapper.updateBoard(replyVO);		
	}

	// 삭제 처리 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public void deleteBoard(Integer rno) throws Exception {
		replyMapper.deleteBoard(rno);
	}

	// 정보 목록 불러오기 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public List<ReplyVO> listAllReplyVO(Integer bno) throws Exception {		
		return replyMapper.listAllReplyVO(bno);
	}

	// rno 번호를 정보 불러오기 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public ReplyVO getRnoInfo(Integer rno) throws Exception {

		return replyMapper.getRnoInfo(rno);
	}

	// 비밀번호와 rno 번호로 삭제처리 ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public void removePassowrd(ReplyVO replyVO) throws Exception {
		replyMapper.removePassowrd(replyVO);
		
	}

	// 비밀번호 가져오기  ->  ReplyMapper 로 이동후  처리 된다
	@Override
	public Integer getPasowrdConfirm(ReplyVO replyVO) throws Exception {
		
		return replyMapper.getPasowrdConfirm(replyVO);
	}
	
	

}
