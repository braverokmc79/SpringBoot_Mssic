package ic.mss.model.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserVO {

	private Integer id;
	
	@NotNull(message="* 아이디를 입력해 해주세요.")
	@NotEmpty(message="* 아이디를 입력해 해주세요.")
	private String userID;
	
	@NotNull(message="* 닉네임을 입력해 주세요.")
	@NotEmpty(message="* 닉네임을 입력해 주세요.")
	private String nickname;
	
	@NotNull(message="* 비밀번호를 입력해 주세요.")
	@NotEmpty(message="* 비밀번호를 입력해 주세요.")
	private String pw;
	
	@NotNull(message="* 비밀번호 확인을 입력해 주세요.")
	@NotEmpty(message="* 비밀번호 확인을 입력해 주세요.")
	private String pwConfirm;
	
	private String ip;
	
	public boolean pwCompare() {		
		if(this.pw.equals(this.pwConfirm)) {
			return true;
		}		
		return false;
	}

	
}



