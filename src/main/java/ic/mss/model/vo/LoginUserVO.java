package ic.mss.model.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginUserVO {

	private int no;
	
	@NotNull(message="* 아이디를 입력해 해주세요.")
	@NotEmpty(message="* 아이디를 입력해 해주세요.")
	private String id;
	
	@NotNull(message="* 비밀번호를 입력해 주세요.")
	@NotEmpty(message="* 비밀번호를 입력해 주세요.")
	private String pw;
	
	
	
}



