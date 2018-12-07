package ic.mss.model.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserVO {

	private int no;
	
	@NotNull(message="* 아이디를 입력해 해주세요.")
	@NotEmpty(message="* 아이디를 입력해 해주세요.")
	private String id;
	
	@NotNull(message="* 비밀번호를 입력해 주세요.")
	@NotEmpty(message="* 비밀번호를 입력해 주세요.")
	private String pw;
	
	@NotNull(message="* 이메일을 입력해 주세요.")
	@NotEmpty(message="* 이메일을 입력해 주세요.")
	@Email(message="이메일 형식에 맞지 않습니다.")
	private String email;
	
	@NotNull(message="* 비밀번호 확인을 입력해 주세요.")
	@NotEmpty(message="* 비밀번호 확인을 입력해 주세요.")
	private String pwConfirm;
	
	
	public boolean pwCompare() {		
		if(this.pw.equals(this.pwConfirm)) {
			return true;
		}		
		return false;
	}

	
}



