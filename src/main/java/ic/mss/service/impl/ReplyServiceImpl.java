package ic.mss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.ReplyMapper;
import ic.mss.model.vo.ReplyVO;
import ic.mss.service.ReplyService;


/**
 * @author 최준호 (braverokmc79@gmail.com)
     
   @생성일 2018. 12. 2. 오후 1:08:01
	
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	
	private static final Logger log = LoggerFactory.getLogger(ReplyServiceImpl.class);

	
	@Autowired
	private ReplyMapper replyMapper;


	@Override
	public void createBoard(ReplyVO replyVO) throws Exception {
		replyMapper.createBoard(replyVO);				
	}


	@Override
	public ReplyVO readBoard(Integer bno) throws Exception {		
		return replyMapper.readBoard(bno) ;
	}


	@Override
	public void updateBoard(ReplyVO replyVO) throws Exception {
		replyMapper.updateBoard(replyVO);		
	}


	@Override
	public void deleteBoard(Integer rno) throws Exception {
		replyMapper.deleteBoard(rno);
	}


	@Override
	public List<ReplyVO> listAllReplyVO(Integer bno) throws Exception {		
		return replyMapper.listAllReplyVO(bno);
	}


	@Override
	public ReplyVO getRnoInfo(Integer rno) throws Exception {

		return replyMapper.getRnoInfo(rno);
	}


	@Override
	public void removePassowrd(ReplyVO replyVO) throws Exception {
		replyMapper.removePassowrd(replyVO);
		
	}


	@Override
	public Integer getPasowrdConfirm(ReplyVO replyVO) throws Exception {
		
		return replyMapper.getPasowrdConfirm(replyVO);
	}
	
	

}
