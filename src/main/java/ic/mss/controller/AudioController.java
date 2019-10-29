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
	
	//스트링 부트에서 저장할 위치이다.
	//private String uploadDirectory="src/main/resources/static/mp3";

	//리눅스에서 저장 파일 디렉토리 위치이다.
	private String uploadDirectory="/home/mssic/public_html/ROOT/WEB-INF/classes/static/mp3";
	
	
	// get 방식 post 방식 호출 상관 없이 /audio/list  이동하게 한다.
	@RequestMapping("list")
	public String streamingList(PageMakerAndSearch pageMaker, AudioVO audioVO, Model model) throws Exception{		
		
		//tbl_audio 테이블의 오디오 전체 갯수를 구한다.
		Integer totalCount=audioService.audioTotalCount(pageMaker);
		
		//페이징 계산하는 PageMakerAndSearch 넣는다.
		pageMaker.setTotalCount(totalCount);
		pageMaker.setPerPageNum(25); // 25개 줄씩 표시하도록 한다.
		pageMaker.setDisplayPageNum(3);  // 3개씩 페이징이 보이도록 한다.

		// tbl_audio 테이블의 오디오 재생 플레이 목록을 가져온다.
		List<AudioVO> list=audioService.audioList(pageMaker);
		
		//페이징 처리를 해서 html로 뿌려주는 것을   pagination 변수에 넣은당.
		String pagination=pageMaker.bootStrapPagingSearchHTML4("/audio/list");
		
		model.addAttribute("pagination", pagination); //페이징 String  담는다
		model.addAttribute("pageMaker", pageMaker);   //페이지 메이커 객체를 담는다.
		model.addAttribute("totalCount", totalCount); // 전체 개수를 구한 totalcount 를 담는다.
		model.addAttribute("list", list);  // 목록처리한 List<AudioVO> 객체를  담는다.
		
		//  src/main/webapp/WEB-INF/views/mss 의 
		// mss/audio/list.jsp  로 이동 처리한다.
		return "mss/audio/list";
	}

	
	// get 방식으로 /audio/write 가 호출 되었을 때  audio 업로드 폼으로 이동한다.
	@GetMapping("write")
	public String mpUploadForm() throws Exception{	
    	  //  src/main/webapp/WEB-INF/views/mss 의 
	    // mss/audio/write.jsp  로 이동 처리한다.
		return "mss/audio/write";
	}
	
	
	// post 방식으로  audio/upload 가 호출시  파일 업로드 처리를 한다.
	@PostMapping("upload")
	public String upload(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("file") AudioVO audioVO) throws Exception {
		
		// private MultipartFile file 의 필드에  저장 된 file 파일 이름를  originalName 에 넣는다.
		audioVO.setOriginalName(audioVO.getFile().getOriginalFilename());
		//파일이 업로드 되고나서 반환 되는 파일 디릭토리 이름과 저장된 이름을 fullName 변수에 담는다.
		String fullName=fileUploadController.uploadFile(uploadDirectory, audioVO.getOriginalName(), audioVO.getFile().getBytes());
		// fullName 필드에 담는다.
		audioVO.setFullName(fullName);
		
		// 최종적으로  DB에 넣는다.
		audioService.inesrt(audioVO);
		// 데이터를 업로드 후에는 리다이렉트 방식으로 이동으로  url  /audio/list  페이지로 이동시킨다.
		return "redirect:list";
	}
	
	
	// /audio/showchange  주소가 호출 될 경우  다음을 처리한다.
	@PostMapping("showchange")
	public void showchange(AudioVO audioVO, HttpServletResponse response) throws Exception{		
		//log.info("showchange");
		//ajax 로 호출 될시  처리 답변으로 PrintWriter 를 이용한다.
		PrintWriter out =response.getWriter();		
		try {
			// tbl_audio 의서 show 컬럼의 defualt 값이 no 이다  , no 일경우 
			//메인 화면의 스트리밍 목록에 출력이 안된다 .  ajax 로 넘겨온 데이타가 no 일경우  yes 변경시키고
			// yes 일 경우 no 변경  시킨다.
			String show="";
			if(audioVO.getShow().equals("no")) {
				show="yes";
			}else {
				show="no";				
			}
			audioVO.setShow(show);
			
			// DB 에 저장 시킨다.
			audioService.showChange(audioVO);
			// 에러없이 잘 처리 될경우 ajax 에 success 라고 반환 시킨다.
			out.print("success");
		}catch (Exception e) {
			e.printStackTrace();
			// 실패시 faild 반환
			out.print("faild");
		}
		
	}
	
	
	// Post 방식으로 /audio/deleteAudio 될 경우 다음의 삭제 처리를 진행한다.
	@PostMapping("deleteAudio")
	public void deleteAudio(AudioVO audioVO, HttpServletResponse response) throws Exception{		
		// ajax 로 데이터 통신으로  반환시 PrintWriter 를 이용한다.
		PrintWriter out =response.getWriter();		
		try {
			// ajax 에서 id 번호가 가져오는 데 이것을 audioGetInfo 를 통해 상세한 정보를 가져온다.
			// 왜냐하면은 DB 담기 파일이름과 저장된 위치를 가져와 삭제 처리하기 위함이다.
			AudioVO audioInfo=audioService.audioGetInfo(audioVO);			
			//파일 삭제처리로 물리적 위치  
			// 예 /home/mssic/public_html/ROOT/WEB-INF/classes/static/mp3/2018/12/15  
			//+ 482c015f-1c92-4ce6-8df0-5fba1b56de2e_4minute-I My Me Mine.mp3
			// 로 찾아가서 해당 파일 을 삭제 한다. 
			new File(uploadDirectory+audioInfo.getFullName()).delete();
			
			//DB 데이터를 삭제 처리한다.
			audioService.delete(audioInfo);
			//성공시 success 를 반환시킨다.
			out.print("success");
		}catch (Exception e) {
			e.printStackTrace();
			//실패시 faild 를 반환시킨다.
			out.print("faild");
		}
		
	}
	
	
	
	
}
