package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.MessageVO;

@Repository
public interface MessageMapper {

		public void messageCreate(MessageVO messageVO) throws Exception;	//create 
		
		public List<MessageVO> messageGetList(MessageVO messageVO) throws Exception; 	//Read  List		
		
		public MessageVO messageGet(MessageVO memberVO) throws Exception; 		//Read
		
		public void messageUpdate(MessageVO messageVO) throws Exception;    //update

		public void  messageDelete(MessageVO messageVO) throws Exception;   //Delete

		public List<MessageVO> messageAllList() throws Exception; 
		
		
		
}





