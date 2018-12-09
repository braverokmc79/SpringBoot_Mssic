package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.ReplyVO;
/**
 * @author 최준호 (braverokmc79@gmail.com)
     
   @생성일 2018. 11. 22. 오전 1:18:50
	
 */
@Repository
public interface ReplyMapper {

	public void createBoard(ReplyVO replyVO) throws Exception;
	
	public ReplyVO readBoard(Integer rno) throws Exception;
	
	public void updateBoard(ReplyVO replyVO) throws Exception;
	
	public void deleteBoard(Integer rno) throws Exception;
	
	public List<ReplyVO> listAllReplyVO(Integer bno) throws Exception;

	public ReplyVO getRnoInfo(Integer rno) throws Exception;
	
	public void removePassowrd(ReplyVO replyVO) throws Exception;

	public Integer getPasowrdConfirm(ReplyVO replyVO) throws Exception;
}


