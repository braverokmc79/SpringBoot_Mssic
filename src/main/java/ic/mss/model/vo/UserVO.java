package ic.mss.model.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

/*CREATE TABLE `tbl_user` (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `userID` varchar(50) NOT NULL,
		  `nickname` varchar(50) NOT NULL,
		  `pw` varchar(100) NOT NULL,
		  `ip` varchar(50) NOT NULL,
		  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

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


	
}



