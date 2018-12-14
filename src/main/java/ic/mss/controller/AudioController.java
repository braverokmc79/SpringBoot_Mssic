package ic.mss.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ic.mss.model.vo.AudioVO;
import ic.mss.service.AudioService;
import ic.mss.util.config.PageMakerAndSearch;

@Controller
@RequestMapping("/audio/**")
public class AudioController {

	private static final Logger log = LoggerFactory.getLogger(AudioController.class);

	
//	@Value("${upload.path}")
	//private String uploadDirectory;
	
	@Autowired
	private FileUploadController fileUploadController;
	
	@Autowired
	private AudioService audioService;
	
	private String uploadDirectory="src/main/resources/static/mp3";

	@RequestMapping("list")
	public String streamingList(PageMakerAndSearch pageMaker, AudioVO audioVO, Model model) throws Exception{		
		
		Integer totalCount=audioService.audioTotalCount(pageMaker);
		
		pageMaker.setTotalCount(totalCount);
		pageMaker.setPerPageNum(25);
		pageMaker.setDisplayPageNum(3);
		
		List<AudioVO> list=audioService.audioList(pageMaker);
		
		String pagination=pageMaker.bootStrapPagingSearchHTML4("/audio/list");
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "mss/audio/list";
	}

	
	
	@GetMapping("write")
	public String mpUploadForm() throws Exception{	
		return "mss/audio/write";
	}
	
	
	
	@PostMapping("upload")
	public String upload(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("file") AudioVO audioVO) throws Exception {
		
		
		audioVO.setOriginalName(audioVO.getFile().getOriginalFilename());
		String fullName=fileUploadController.uploadFile(uploadDirectory, audioVO.getOriginalName(), audioVO.getFile().getBytes());
		audioVO.setFullName(fullName);
		
		audioService.inesrt(audioVO);
		
		return "redirect:list";
	}
	
	@PostMapping("showchange")
	public void showchange(AudioVO audioVO, HttpServletResponse response) throws Exception{		
		//log.info("showchange");
		PrintWriter out =response.getWriter();		
		try {
			String show="";
			if(audioVO.getShow().equals("no")) {
				show="yes";
			}else {
				show="no";				
			}
			audioVO.setShow(show);
			audioService.showChange(audioVO);
			out.print("success");
		}catch (Exception e) {
			e.printStackTrace();
			out.print("faild");
		}
		
	}
	
	
	
	@PostMapping("deleteAudio")
	public void deleteAudio(AudioVO audioVO, HttpServletResponse response) throws Exception{		
		PrintWriter out =response.getWriter();		
		try {
			AudioVO audioInfo=audioService.audioGetInfo(audioVO);			
			//파일 삭제
			new File(uploadDirectory+audioInfo.getFullName()).delete();
			//DB 삭제
			audioService.delete(audioInfo);
			out.print("success");
		}catch (Exception e) {
			e.printStackTrace();
			out.print("faild");
		}
		
	}
	
	
	
	
}
