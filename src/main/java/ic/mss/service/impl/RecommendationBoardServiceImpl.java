package ic.mss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.RecommendationBoardMapper;
import ic.mss.model.vo.BoardVO;
import ic.mss.service.RecommendationBoardService;
import ic.mss.util.config.PageMakerAndSearch;

@Service
public class RecommendationBoardServiceImpl implements RecommendationBoardService {

	
	private static final Logger log = LoggerFactory.getLogger(RecommendationBoardServiceImpl.class);

	// RecommendationBoardMapper 객체를  의존성 주입시킨다. 
	@Autowired
	private RecommendationBoardMapper  mapper;
	
	
	// 등록 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public void register(BoardVO boardVO) throws Exception {
		mapper.register(boardVO);
	}

	// 한개의 정보 가져오기  - 읽기 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public BoardVO getRead(BoardVO boardVO) throws Exception {
		return mapper.getRead(boardVO);
	}

	
	// 목록 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public List<BoardVO> getReadList(PageMakerAndSearch pageMaker) throws Exception {
		return mapper.getReadList(pageMaker);
	}

	// 삭제 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public void remove(BoardVO boardVO) throws Exception {
		mapper.remove(boardVO);
	}

	// 업데이트 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		mapper.boardUpdate(boardVO);
	}
	 
	//비밀번호 확인 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public Integer passwordConfirm(BoardVO boardVO) throws Exception {
		return mapper.passwordConfirm(boardVO);
	}

	// 전체 개수 가져오기   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public Integer boardTotalCount(PageMakerAndSearch pageMaker) throws Exception {
		return mapper.boardTotalCount(pageMaker);
	}

	// 조회수 증가 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public void viewcntAdd(BoardVO boardVO) throws Exception {
		mapper.viewcntAdd(boardVO);
	}

	// 상세보기의 목록 처리   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public List<BoardVO> getReadLikeList() throws Exception {
		return mapper.getReadLikeList();
	}

	//조회수 많은 것 가져오기   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public List<BoardVO> bestViewList() throws Exception {		
		return mapper.bestViewList();
	}

	//  댓글 많은것 목록 가져오기   ->  RecommendationBoardMapper 로 이동후  처리
	@Override
	public List<BoardVO> bestCommentList() throws Exception {	
		return mapper.bestCommentList();
	}

}
