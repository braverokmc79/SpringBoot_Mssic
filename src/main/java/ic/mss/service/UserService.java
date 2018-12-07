package ic.mss.service;

import java.util.List;

import ic.mss.model.vo.UserVO;


public interface UserService {

	public void userCreate(UserVO userVO) throws Exception; 

	public List<UserVO>userGetList() throws Exception; 	
	
	public UserVO userGet(UserVO userVO) throws Exception; 
	
	
	public UserVO userGetEmail(UserVO userVO) throws Exception; 
	
	public void userUpdate(UserVO userVO) throws Exception;
	
	public void  userDelete(UserVO userVO) throws Exception;

	public UserVO userPwdConfirm(UserVO userVO) throws Exception;;   
		
	
	
	
}
