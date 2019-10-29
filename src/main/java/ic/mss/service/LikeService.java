package ic.mss.service;

import java.util.List;

import ic.mss.model.vo.LikeVO;

//interface 의 LikeService 부모 객체로   상속 시켜 준다
public interface LikeService {
	//  목록 처리 
	public List<LikeVO> likeList(LikeVO likeVO) throws Exception;
	// 등록 처리 
	public void insert(LikeVO likeVO) throws Exception;
	//삭제 처리 
	public void delete(LikeVO likeVO) throws Exception;
	
}
