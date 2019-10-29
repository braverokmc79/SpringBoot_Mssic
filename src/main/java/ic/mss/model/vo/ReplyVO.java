package ic.mss.model.vo;

import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;
/*
 * 
CREATE TABLE `tbl_reply` (
		  `rno` int(11) NOT NULL AUTO_INCREMENT,
		  `bno` int(11) NOT NULL,
		  `r_content` varchar(1000) DEFAULT NULL,
		  `userID` varchar(50) DEFAULT NULL,
		  `r_nickname` varchar(20) NOT NULL,
		  `r_pw` varchar(50) DEFAULT NULL,
		  `r_ip` varchar(50) DEFAULT NULL,
		  `r_regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`rno`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/

@Data
public class ReplyVO {

	private Integer rno;  //댓글 아이디
	private Integer bno;  	// 게시판 아이디
	
	@NotBlank(message = "* 내용을 입력해 주세요.")
	private String content;	 //내용
	private String userID;	 //유저 아이디
	
	private String rnickname;	 // 닉네임
	private String rpw; //패스워드
	
	private String rip; // 아이피
	
	private Date regdate; // 등록일

	
	
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



