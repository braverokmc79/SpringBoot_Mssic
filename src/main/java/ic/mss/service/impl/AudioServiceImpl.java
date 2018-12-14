package ic.mss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.AudioMapper;
import ic.mss.model.vo.AudioVO;
import ic.mss.service.AudioService;
import ic.mss.util.config.PageMakerAndSearch;

@Service
public class AudioServiceImpl implements AudioService{

	@Autowired
	private AudioMapper audioMapper;
	
	
	@Override
	public void inesrt(AudioVO audioVO) throws Exception {
		audioMapper.inesrt(audioVO);
	}

	@Override
	public List<AudioVO> audioList(PageMakerAndSearch pageMaker) throws Exception {		
		return audioMapper.audioList(pageMaker);
	}

	@Override
	public void delete(AudioVO audioVo) throws Exception {
		audioMapper.delete(audioVo);
	}

	@Override
	public void showChange(AudioVO audioVO) throws Exception {
		audioMapper.showChange(audioVO);
	}

	@Override
	public Integer audioTotalCount(PageMakerAndSearch pageMaker) throws Exception {

		return audioMapper.audioTotalCount(pageMaker);
	}

	@Override
	public List<AudioVO> getStreamingList() throws Exception {
		
		return audioMapper.getStreamingList();
	}

	@Override
	public AudioVO audioGetInfo(AudioVO audioVO) throws Exception {
	
		return audioMapper.audioGetInfo(audioVO);
	}

	
}
