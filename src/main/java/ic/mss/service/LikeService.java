package ic.mss.service;

import java.util.List;

import ic.mss.model.vo.LikeVO;


public interface LikeService {

	public List<LikeVO> likeList(LikeVO likeVO) throws Exception;
	
	public void insert(LikeVO likeVO) throws Exception;
	
	public void delete(LikeVO likeVO) throws Exception;
	
}
