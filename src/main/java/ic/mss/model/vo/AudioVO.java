package ic.mss.model.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/*CREATE TABLE `tbl_audio` (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `title` varchar(300) DEFAULT NULL,
		  `fullName` varchar(250) DEFAULT NULL,
		  `originalName` varchar(250) DEFAULT NULL,
		  `show` varchar(10) DEFAULT 'no',
		  `regdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/

@Data
public class AudioVO {

	private Integer id; // 아이디 
	private String title; //제목
	private String fullName; // 파일경로를 포함한  저장된 파일 이름
	private String originalName; //업로드한 원래 파일 이름
	private String show;	// 기본값 no  yes 메인에 스트리밍 플레이
	private MultipartFile file;	// mp3 파일을 업로드 하기 위한 것
	private Date regdate; //등록일
	
	
	
}
