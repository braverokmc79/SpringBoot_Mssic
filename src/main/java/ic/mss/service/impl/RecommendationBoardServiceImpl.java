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

	@Autowired
	private RecommendationBoardMapper  mapper;
	
	@Override
	public void register(BoardVO boardVO) throws Exception {
		mapper.register(boardVO);
	}

	@Override
	public BoardVO getRead(BoardVO boardVO) throws Exception {
		return mapper.getRead(boardVO);
	}

	@Override
	public List<BoardVO> getReadList(PageMakerAndSearch pageMaker) throws Exception {
		return mapper.getReadList(pageMaker);
	}

	@Override
	public void remove(BoardVO boardVO) throws Exception {
		mapper.remove(boardVO);
	}

	@Override
	public void boardUpdate(BoardVO boardVO) throws Exception {
		mapper.boardUpdate(boardVO);
	}

	@Override
	public Integer passwordConfirm(BoardVO boardVO) throws Exception {
		return mapper.passwordConfirm(boardVO);
	}

	@Override
	public Integer boardTotalCount(PageMakerAndSearch pageMaker) throws Exception {
		return mapper.boardTotalCount(pageMaker);
	}

	@Override
	public void viewcntAdd(BoardVO boardVO) throws Exception {
		mapper.viewcntAdd(boardVO);
	}

	@Override
	public List<BoardVO> getReadLikeList() throws Exception {
		return mapper.getReadLikeList();
	}

	@Override
	public List<BoardVO> bestViewList() throws Exception {		
		return mapper.bestViewList();
	}

	@Override
	public List<BoardVO> bestCommentList() throws Exception {	
		return mapper.bestCommentList();
	}

}
