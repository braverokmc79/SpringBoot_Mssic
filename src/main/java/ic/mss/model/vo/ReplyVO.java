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

	
	
}



