package ic.mss.model.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AudioVO {

	private Integer id;
	private String title;
	private String fullName;
	private String originalName;
	private String show;	
	private MultipartFile file;	
	private Date regdate;
	
	
	
}
