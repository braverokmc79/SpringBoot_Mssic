package ic.mss.model.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
/*
CREATE TABLE `tbl_board` (
		  `bno` int(11) NOT NULL AUTO_INCREMENT,
		  `title` varchar(200) NOT NULL,
		  `content` text,
		  `userID` varchar(50) DEFAULT NULL,
		  `bnickname` varchar(20) NOT NULL,
		  `pw` varchar(50) DEFAULT NULL,
		  `ip` varchar(50) DEFAULT NULL,
		  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  `viewcnt` int(11) DEFAULT '0',
		  `imgcnt` int(11) DEFAULT '0',
		  PRIMARY KEY (`bno`)
		) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
*/

@Data
public class BoardVO {

	private Integer bno;  //아이디
	
	@Size(max=50, message="* 제목은 1~50 글자 사이로 입력해 주세요.")
	@NotNull(message="* 제목을 입력해 해주세요.")
	@NotEmpty(message="* 제목을 입력해 해주세요.")
	private String title;
	
	
	@NotNull(message="* 내용을 입력해 해주세요.")
	@NotEmpty(message="* 내용을 입력해 해주세요.")
	private String content;
	
	
	private String userID; //유저 아이디
	
	@Size(max=10, message="* 닉네임을 1~10 글자 사이로 입력해 주세요.")
	@NotNull(message="* 닉네임을 입력해 해주세요.")
	@NotEmpty(message="* 닉네임을 입력해 해주세요.")
	private String bnickname;
	
	
	private Integer imgcnt; //이미지 가 등록되었는지 확인

	
/*	@Size(min=4, max=4, message="* 비밀번호 4자리로 입력해 주세요.")
	@NotNull(message="* 비밀번호를 입력해 해주세요.")
	@NotEmpty(message="* 비밀번호를 입력해 해주세요.")*/
	private String pw;
	
	
	private String ip;	//아이피
	private Date regdate;	//등록일
	private Integer viewcnt;  //조회수
	
	private Integer rplycnt; //답변수
	
	private Integer likecnt; // 추천

	//xss 제목과 닉네임에서  스크립트 제거 처리를 한다.
	public void setting() {
		this.title=cleanXSS(this.title);
		this.bnickname=cleanXSS(this.bnickname);
	}
	
	//xss 스크립트 제거
	private String cleanXSS(String value) {
		 value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		 value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");
		 value = value.replaceAll("'", "&#39;");
		 value = value.replaceAll("eval\\((.*)\\)", "");
		 value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
		 value = value.replaceAll("script", "");
		 return value;
	}



}
