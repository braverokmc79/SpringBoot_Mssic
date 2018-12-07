package ic.mss.model.dao.mapper;

import org.springframework.stereotype.Repository;

import ic.mss.model.vo.AlarmVO;

@Repository
public interface AlarmMapper {
	
    public AlarmVO getIdData(AlarmVO alarmVO)  throws Exception;

    public void insertAlarm(AlarmVO alarmVO) throws Exception;

    public void updateAlarm(AlarmVO alarmVO) throws Exception;
	
    
    
}
