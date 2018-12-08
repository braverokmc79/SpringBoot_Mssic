package ic.mss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.UserMapper;
import ic.mss.model.vo.UserVO;
import ic.mss.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;

	//아이디 중복 체크
	@Override
	public Integer userGet(UserVO userVO) throws Exception {
		return userMapper.userGet(userVO);
	}

	// 닉네임 중복 체크
	@Override
	public Integer userGetNickname(UserVO userVO) throws Exception {
		return userMapper.userGetNickname(userVO);
	}

	//유저 가입 생성
	@Override
	public void userCreate(UserVO userVO) throws Exception {
		userMapper.userCreate(userVO);
	}
	
	
	
	
	
}
