package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.BoardVO;
import ic.mss.util.config.PageMakerAndSearch;

@Repository
public interface RecommendationBoardMapper {
	
	//등록
	public void register(BoardVO boardVO) throws Exception;	
	//읽기
	public BoardVO getRead(BoardVO boardVO) throws Exception;		
	//목록
	public List<BoardVO> getReadList(PageMakerAndSearch pageMaker) throws Exception;	
	//삭제
	public void remove(BoardVO boardVO) throws Exception;	
	//변경
	public void boardUpdate(BoardVO boardVO) throws Exception;	

	//비밀번호 확인
	public Integer passwordConfirm(BoardVO boardVO) throws Exception;
	
	
	//전체 게시판 갯수
	public Integer boardTotalCount(PageMakerAndSearch pageMaker) throws Exception;
	
	//조회수 증가
	public void viewcntAdd(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> getReadLikeList() throws Exception;
}
