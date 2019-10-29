package ic.mss.service;

import java.util.List;

import ic.mss.model.vo.AudioVO;
import ic.mss.util.config.PageMakerAndSearch;

//interface 의 AudioServiceImpl 부모 객체로   상속 시켜 준다
public interface AudioService {

	//등록 메서드
	public void inesrt(AudioVO audioVO)  throws Exception;
	// 목록 
	public List<AudioVO> audioList(PageMakerAndSearch pageMaker) throws Exception;
	// 삭제
	public void delete(AudioVO audioVo) throws Exception;
	//스트리밍 여부  기본값 no  yes 면  스트리밍 메서드
	public void showChange(AudioVO audioVO) throws Exception;
	//   전체 개수를 가져온다
	public Integer audioTotalCount(PageMakerAndSearch pageMaker) throws Exception;
	// show 컬럼에서 yes 만 가져온다.
	public List<AudioVO> getStreamingList() throws Exception;
	// 해당  id 의 정보를 가져온다.
	public AudioVO audioGetInfo(AudioVO audioVO) throws Exception;
	
}
