package ic.mss.service;

import ic.mss.model.vo.AlarmVO;

public interface AlarmService {

    public AlarmVO getIdData(AlarmVO alarmVO)  throws Exception;

    public void insertAlarm(AlarmVO alarmVO) throws Exception;

    public void updateAlarm(AlarmVO alarmVO) throws Exception;

}
