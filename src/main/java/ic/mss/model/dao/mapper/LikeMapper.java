package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.LikeVO;

@Repository
public interface LikeMapper {

	
	public List<LikeVO> likeList(LikeVO likeVO) throws Exception;
		
	public void insert(LikeVO likeVO) throws Exception;
	
	public void delete(LikeVO likeVO) throws Exception;
	
	
	
}
