package ic.mss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.LikeMapper;
import ic.mss.model.vo.LikeVO;
import ic.mss.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

	@Autowired
	private LikeMapper likeMapper ;
	
	@Override
	public List<LikeVO> likeList(LikeVO likeVO) throws Exception {
		return likeMapper.likeList(likeVO);
	}

	@Override
	public void insert(LikeVO likeVO) throws Exception {
		likeMapper.insert(likeVO);
	}

	@Override
	public void delete(LikeVO likeVO) throws Exception {
		likeMapper.delete(likeVO);
	}

}
