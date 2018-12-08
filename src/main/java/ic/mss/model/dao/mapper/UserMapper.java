package ic.mss.model.dao.mapper;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.UserVO;

@Repository
public interface UserMapper {

	//아이디 중복 체크
	public Integer userGet(UserVO userVO) throws Exception; 
	
	// 닉네임 중복 체크
	public Integer userGetNickname(UserVO userVO)  throws Exception;   
	
	//유저 가입 생성
	public void userCreate(UserVO userVO) throws Exception; 
	
	//유저 로그인
	public UserVO userLoginIdPw(UserVO userVO) throws Exception;  
	

	
}
