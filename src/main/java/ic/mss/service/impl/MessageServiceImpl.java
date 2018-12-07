package ic.mss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.MessageMapper;
import ic.mss.model.vo.MessageVO;
import ic.mss.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	
	private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Autowired
	private MessageMapper messageMapper;

	
	@Override
	public void messageCreate(MessageVO messageVO) throws Exception {
		messageMapper.messageCreate(messageVO);
	}

	@Override
	public List<MessageVO> messageGetList(MessageVO messageVO) throws Exception {
		return messageMapper.messageGetList(messageVO);
	}

	
	@Override
	public MessageVO messageGet(MessageVO memberVO) throws Exception {	
		return messageMapper.messageGet(memberVO);
	}

	
	@Override
	public void messageUpdate(MessageVO messageVO) throws Exception {		
		messageMapper.messageUpdate(messageVO);
	}

	@Override
	public void messageDelete(MessageVO messageVO) throws Exception {
		messageMapper.messageDelete(messageVO);
	}

	@Override
	public List<MessageVO> messageAllList() throws Exception {
		return messageMapper.messageAllList();
	}
	

}
