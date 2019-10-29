package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.LikeVO;

@Repository
public interface LikeMapper {

	// tbl_like 테이블에 목록 처리 이다.  -> mapper.xml 로 이동후 sql 문 처리
	public List<LikeVO> likeList(LikeVO likeVO) throws Exception;
	
	// tbl_like 테이블에 등록 처리 이다.  -> mapper.xml 로 이동후 sql 문 처리
	public void insert(LikeVO likeVO) throws Exception;
	
	// tbl_like 테이블에 삭제 처리 이다.  -> mapper.xml 로 이동후 sql 문 처리
	public void delete(LikeVO likeVO) throws Exception;
	
	
	
}
