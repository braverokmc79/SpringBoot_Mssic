package ic.mss.model.vo;

import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;

@Data
public class ReplyVO {

	private Integer rno;  
	private Integer bno;  	
	
	@NotBlank(message = "* 내용을 입력해 주세요.")
	private String content;	
	private String userID;	
	
	private String rnickname;	
	private String rpw;
	
	private String rip;
	
	private Date regdate; 

	
	
	public void setting() {
		this.content=cleanXSS(this.content);
		this.rnickname=cleanXSS(this.rnickname);
	}
	
	private String cleanXSS(String value) {
	         //You'll need to remove the spaces from the html entities below
		 value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		 value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		 value = value.replaceAll("'", "&#39;");
		 value = value.replaceAll("eval\\((.*)\\)", "");
		 value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		 value = value.replaceAll("script", "");
		 return value;
	}

	
}



