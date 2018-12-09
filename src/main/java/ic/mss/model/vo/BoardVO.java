package ic.mss.model.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class BoardVO {

	private Integer bno;
	
	@Size(max=50, message="* 제목은 1~50 글자 사이로 입력해 주세요.")
	@NotNull(message="* 제목을 입력해 해주세요.")
	@NotEmpty(message="* 제목을 입력해 해주세요.")
	private String title;
	
	
	@NotNull(message="* 내용을 입력해 해주세요.")
	@NotEmpty(message="* 내용을 입력해 해주세요.")
	private String content;
	
	
	private String userID;
	
	@Size(max=10, message="* 닉네임을 1~10 글자 사이로 입력해 주세요.")
	@NotNull(message="* 닉네임을 입력해 해주세요.")
	@NotEmpty(message="* 닉네임을 입력해 해주세요.")
	private String bnickname;
	
	
	private Integer imgcnt;

	
/*	@Size(min=4, max=4, message="* 비밀번호 4자리로 입력해 주세요.")
	@NotNull(message="* 비밀번호를 입력해 해주세요.")
	@NotEmpty(message="* 비밀번호를 입력해 해주세요.")*/
	private String pw;
	
	
	private String ip;	
	private Date regdate;	
	private Integer viewcnt;
	
	private Integer rplycnt;
	
	private Integer likecnt;

}
