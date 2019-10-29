package ic.mss.model.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import ic.mss.model.vo.AudioVO;
import ic.mss.util.config.PageMakerAndSearch;


@Repository
public interface AudioMapper {

	// tbl_audio 테이블에 데이터 등록이다.  -> mapper.xml 로 이동후 sql 문 처리
	public void inesrt(AudioVO audioVO)  throws Exception;

	// tbl_audio 테이블에의 목록 리스트 처리  -> mapper.xml 로 이동후 sql 문 처리
	public List<AudioVO> audioList(PageMakerAndSearch pageMaker) throws Exception;

	// tbl_audio 테이블에의 삭제 처리  -> mapper.xml 로 이동후 sql 문 처리
	public void delete(AudioVO audioVo) throws Exception;
	
	// tbl_audio 테이블에의 스트리밍 여부  기본값 no  yes 면  스트리밍
	public void showChange(AudioVO audioVO) throws Exception;

	// tbl_audio 테이블에의  전체 개수를 가져온다
	public Integer audioTotalCount(PageMakerAndSearch pageMaker) throws Exception;
	
	// tbl_audio 테이블에의  show 컬럼에서 yes 만 가져온다.
	public List<AudioVO> getStreamingList() throws Exception;
	
	// tbl_audio 테이블에의  해당  id 의 정보를 가져온다.
	public AudioVO audioGetInfo(AudioVO audioVO) throws Exception;
		
}
