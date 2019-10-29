package ic.mss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.LikeMapper;
import ic.mss.model.vo.LikeVO;
import ic.mss.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService {

	// LikeMapper 객체를  의존성 주입시킨다.
	@Autowired
	private LikeMapper likeMapper ;
	
	// 목록 처리  -> LikeMapper 로 이동후  처리
	@Override
	public List<LikeVO> likeList(LikeVO likeVO) throws Exception {
		return likeMapper.likeList(likeVO);
	}

	// 삽입 처리  -> LikeMapper 로 이동후  처리
	@Override
	public void insert(LikeVO likeVO) throws Exception {
		likeMapper.insert(likeVO);
	}

	// 삭제 처리  -> LikeMapper 로 이동후  처리
	@Override
	public void delete(LikeVO likeVO) throws Exception {
		likeMapper.delete(likeVO);
	}

}
