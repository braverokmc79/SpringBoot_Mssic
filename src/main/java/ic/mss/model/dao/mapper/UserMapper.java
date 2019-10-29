package ic.mss.model.dao.mapper;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.UserVO;

@Repository
public interface UserMapper {

	//아이디 중복 체크  -> mapper.xml 로 이동후 sql 문 처리
	public Integer userGet(UserVO userVO) throws Exception; 
	
	// 닉네임 중복 체크 -> mapper.xml 로 이동후 sql 문 처리
	public Integer userGetNickname(UserVO userVO)  throws Exception;   
	
	//유저 가입 생성  -> mapper.xml 로 이동후 sql 문 처리
	public void userCreate(UserVO userVO) throws Exception; 
	
	//유저 로그인  -> mapper.xml 로 이동후 sql 문 처리
	public UserVO userLoginIdPw(UserVO userVO) throws Exception;  
	

	
}
