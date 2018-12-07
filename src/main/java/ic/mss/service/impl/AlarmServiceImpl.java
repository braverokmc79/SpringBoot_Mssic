package ic.mss.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ic.mss.model.dao.mapper.AlarmMapper;
import ic.mss.model.vo.AlarmVO;
import ic.mss.service.AlarmService;

@Service
public class AlarmServiceImpl implements AlarmService {

	
	@Autowired
	private AlarmMapper alarmMapper;
	
	
	@Override
	public AlarmVO getIdData(AlarmVO alarmVO) throws Exception {		
		return alarmMapper.getIdData(alarmVO);
	}

	@Override
	public void insertAlarm(AlarmVO alarmVO) throws Exception {
		alarmMapper.insertAlarm(alarmVO);
		
	}

	@Override
	public void updateAlarm(AlarmVO alarmVO) throws Exception {
		alarmMapper.updateAlarm(alarmVO);		
	}

}
