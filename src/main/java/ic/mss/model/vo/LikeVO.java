package ic.mss.model.vo;

import java.util.Date;

import lombok.Data;

/*CREATE TABLE `tbl_like` (
		  `lno` int(11) NOT NULL AUTO_INCREMENT,
		  `bno` int(11) DEFAULT NULL,
		  `lip` varchar(50) DEFAULT NULL,
		  `lregdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`lno`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/

@Data
public class LikeVO {

	private Integer lno; // 추천 아이디
	private Integer bno; // 게시판 번호
	private String  lip;  // 추천 할때 등록한 아이피
	private Date    lregdate; // 등록일
	
}
