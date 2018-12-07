package ic.mss.model.vo;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class MessageVO {

	private Integer eno;
	private String sender;
	private String taker;
	private String sub;
	private String body;
	private Timestamp receivedDate;
	private String grade;
	
	private String formattedDate;
		
	public String getFormattedDate() {
	    if(this.receivedDate!=null) {
			Timestamp ts = this.receivedDate;
			Date date = new Date();
			date.setTime(ts.getTime());
			String Date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			this.formattedDate=Date;
			return formattedDate;
	    }
	    return null;
	}
	
	
	
	
}
