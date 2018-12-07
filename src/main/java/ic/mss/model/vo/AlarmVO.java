package ic.mss.model.vo;

import lombok.Data;

@Data
public class AlarmVO {

	private String userId;
	
	private Integer checkserver;
	private Integer crash;
	private Integer dlpsvr;
	private Integer drmsvr;
	private Integer efilcare01;
	private Integer efilcare02;
	private Integer lifeRecordDatabase01;
	private Integer lifeRecordDatabase02;
	private Integer lifeRecordDatabase03;
	private Integer lifeRecordServer01;
	private Integer lifeRecordServer02;
	private Integer lifeSemanticsService01;
	private Integer lifeSemnaticsService02;
	private Integer postman;

	private String column;
	private Integer checkValue;
	
	
	
}

