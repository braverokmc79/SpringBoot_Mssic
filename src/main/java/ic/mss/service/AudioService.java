package ic.mss.service;

import java.util.List;

import ic.mss.model.vo.AudioVO;
import ic.mss.util.config.PageMakerAndSearch;

public interface AudioService {

	public void inesrt(AudioVO audioVO)  throws Exception;
	
	public List<AudioVO> audioList(PageMakerAndSearch pageMaker) throws Exception;
	
	public void delete(AudioVO audioVo) throws Exception;
	
	public void showChange(AudioVO audioVO) throws Exception;

	public Integer audioTotalCount(PageMakerAndSearch pageMaker) throws Exception;

	public List<AudioVO> getStreamingList() throws Exception;

	public AudioVO audioGetInfo(AudioVO audioVO) throws Exception;
	
}
