package ic.mss.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.ScoreMapper;
import ic.mss.model.vo.ScoreVO;
import ic.mss.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	private static final Logger log = LoggerFactory.getLogger(ScoreServiceImpl.class);
	
	@Autowired
	private ScoreMapper scoreMapper;

	
	@Override
	public void scoreCreate(ScoreVO scoreVO) throws Exception {
		scoreMapper.scoreCreate(scoreVO);
	}

	@Override
	public ScoreVO scoreGet(ScoreVO scoreVO) throws Exception {
		
		return scoreMapper.scoreGet(scoreVO);
	}

	@Override
	public void scoreUpdate(ScoreVO scoreVO) throws Exception {
		scoreMapper.scoreUpdate(scoreVO);
	}
	

	
	
}
