package ic.mss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.AudioMapper;
import ic.mss.model.vo.AudioVO;
import ic.mss.service.AudioService;
import ic.mss.util.config.PageMakerAndSearch;

@Service
public class AudioServiceImpl implements AudioService{

	// AudioMapper 객체를  의존성 주입시킨다.
	@Autowired
	private AudioMapper audioMapper;
	
	//서비스영역으로 처리후  mapper 로 이동 후 데이터 등록
	@Override
	public void inesrt(AudioVO audioVO) throws Exception {
		audioMapper.inesrt(audioVO);
	}

	//서비스영역으로 처리후  -> mapper 로 이동 후 데이터 목록
	@Override
	public List<AudioVO> audioList(PageMakerAndSearch pageMaker) throws Exception {		
		return audioMapper.audioList(pageMaker);
	}

	//서비스영역으로 처리후  mapper 로 이동 후 데이터 삭제
	@Override
	public void delete(AudioVO audioVo) throws Exception {
		audioMapper.delete(audioVo);
	}

	//서비스영역으로 처리후  mapper 로 이동 후 데이터 show  yes, no 체인지 처리
	@Override
	public void showChange(AudioVO audioVO) throws Exception {
		audioMapper.showChange(audioVO);
	}

	//서비스영역으로 처리후  mapper 로 이동 후 데이터 전체 갯수
	@Override
	public Integer audioTotalCount(PageMakerAndSearch pageMaker) throws Exception {
		return audioMapper.audioTotalCount(pageMaker);
	}

	//서비스영역으로 처리후  mapper 로 이동 후 데이터  메이에 보여줄 스트리밍 리스트
	@Override
	public List<AudioVO> getStreamingList() throws Exception {		
		return audioMapper.getStreamingList();
	}

	//서비스영역으로 처리후  mapper 로 이동 후 audio 정보 가져오기
	@Override
	public AudioVO audioGetInfo(AudioVO audioVO) throws Exception {
		return audioMapper.audioGetInfo(audioVO);
	}

	
}
