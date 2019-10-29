package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.BoardVO;
import ic.mss.util.config.PageMakerAndSearch;

@Repository
public interface RecommendationBoardMapper {
	
	//tbl_board 테이블의 등록 처리이다  -> mapper.xml 로 이동후 sql 문 처리
	public void register(BoardVO boardVO) throws Exception;	
	//tbl_board 테이블의 읽기 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public BoardVO getRead(BoardVO boardVO) throws Exception;		
	//tbl_board 테이블의 목록 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public List<BoardVO> getReadList(PageMakerAndSearch pageMaker) throws Exception;	
	//tbl_board 테이블의 삭제 처리 이다.  -> mapper.xml 로 이동후 sql 문 처리
	public void remove(BoardVO boardVO) throws Exception;	
	//tbl_board 테이블의 변경 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public void boardUpdate(BoardVO boardVO) throws Exception;	

	//tbl_board 의 비밀번호 확인 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public Integer passwordConfirm(BoardVO boardVO) throws Exception;
	
	//tbl_board 테이블의 전체 게시판 갯수를 가져오는 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public Integer boardTotalCount(PageMakerAndSearch pageMaker) throws Exception;
	
	//tbl_board 테이블의 조회수 증가 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public void viewcntAdd(BoardVO boardVO) throws Exception;
	
	//tbl_board 테이블의 읽기 상세보기의 목록 처리다  -> mapper.xml 로 이동후 sql 문 처리
	public List<BoardVO> getReadLikeList() throws Exception;
	
	//tbl_board 테이블의 조회수가 높은것 5 개 목록을 가져오는 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public List<BoardVO> bestViewList() throws Exception;
	// tbl_board 테이블의 댓글수가 높은것 5개 목록을 가져오는 처리이다.  -> mapper.xml 로 이동후 sql 문 처리
	public List<BoardVO> bestCommentList() throws Exception;
}
