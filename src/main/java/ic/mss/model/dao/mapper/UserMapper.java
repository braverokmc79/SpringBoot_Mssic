package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.UserVO;

@Repository
public interface UserMapper {

	public void userCreate(UserVO userVO) throws Exception; 

	public List<UserVO>userGetList() throws Exception; 	
	
	public UserVO userGet(UserVO userVO) throws Exception; 
	
	public UserVO userGetEmail(UserVO userVO) throws Exception; 
	
	
	public void userUpdate(UserVO userVO) throws Exception;
	
	public void  userDelete(UserVO userVO) throws Exception;

	public UserVO userPwdConfirm(UserVO userVO) throws Exception;  
	
	
}
