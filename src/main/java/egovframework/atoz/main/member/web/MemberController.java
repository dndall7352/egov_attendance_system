package egovframework.atoz.main.member.web;

import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.atoz.main.member.service.MemberService;
import egovframework.atoz.main.member.service.MemberVO;


@Controller  // 아무 폴더나 다 가져오면 읽는 건가? -> ㅇ

public class MemberController {
	
    @Resource(name="memberService")
    private MemberService memberService;

	// 회원등록화면
	@RequestMapping("/memberWrite.do")
	public String memberWrite() {
		return "member/memberWrite";
	}
//	
	@RequestMapping("/memberWriteSave.do")
    @ResponseBody
	public String insertMember(MemberVO vo) throws Exception {
		String result = memberService.insertMember(vo);
        String msg = "";
        if (result == null) {
            msg = "ok";
        } else {
            msg = "fail";
        }
        return msg;
    }
	
	
	// 흐름 1 서비스를 실행-> sql 실행. -> intager으로 전달 -> 결과값이 controller(int count 어쩌구)로 전달
	@RequestMapping("/idcheck.do")
	@ResponseBody  // 메시지를 화면으로 전달하는 것
	public String selectMemberIdCheck(String userid) throws Exception {
		String message = "";
		
		int count = memberService.selectMemberIdCheck(userid);
				
		if(count == 0) {
			message = "ok";
		}
		
		
		return message;  //메시지 값이 셋팅되어 전달
	}
	
	@RequestMapping("/loginWrtie.do")
	public String loginWrite() {
		return "member/loginWrtie";
	}
	
	@RequestMapping("/loginWriteSub.do")
	@ResponseBody
	public String loginProcess(MemberVO vo, HttpSession session) throws Exception { //vo에서 받아서 서비스에서 태워서 sql까지 보내는 story
		
		String message = "";
		
		int count = memberService.selectmemberCount(vo);
				
		if(count == 1) { // == 1은 존재한다는 뜻
			// session 생성
			session.setAttribute("SessionUserID", vo.getUserid());
			// message 처리
			
			message = "Ok";
		}
		
		return message;  //메시지 값이 셋팅되어 전달
	}
    
//	@PostMapping("/upload")
//	public String uploadFile(@RequestParam("photo") MultipartFile file, ModelMap model) throws Exception { 
//		// photo라는 이름의 파일을 MultipartFile 타입으로 받아오고 model를 매개변수로 지정
//	    try {
//	        MemberVO photo = new MemberVO();
//	        photo.setPhoto(file.getBytes());  // MultipartFile을 byte[]로 변환
//	        memberService.insertMember(photo) ;
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	    return "redirect:/memberWrite";
//	}
//
//	
//	/**
//	 * 파일을 업로드 한다.
//	 * @param request
//	 * @return List<String> 파일명리스트 
//	 * @throws Exception
//	 */
//	public List<String> fileupload(HttpServletRequest request) throws Exception{
//		final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//
//		// extract files
//		final Map<String, MultipartFile> files = multiRequest.getFileMap();
//
//		// process files
//		String uploadLastPath = memberService.getPhoto("file.upload.path");
//		String uploadFileTag = "_"+memberService.getPhoto("Globals.fileUpload.Tag");
//		String uploadPath = uploadLastPath;
//		File saveFolder = new File(uploadPath);
//		String fileName = null;
//		List<String> result = new ArrayList<String>();
//		// 디렉토리 생성
//		boolean isDir = false;
//
//		if (!saveFolder.exists() || saveFolder.isFile()) {
//			saveFolder.mkdirs();
//		}
//
//		if (!isDir) {
//
//			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
//			MultipartFile file;
//			String filePath;
//
//			while (itr.hasNext()) {
//
//				Entry<String, MultipartFile> entry = itr.next();
//				file = entry.getValue();
//				fileName = file.getOriginalFilename();
//				if (!"".equals(fileName)) {
//
//					// macOS 한글 풀어쓰기 => 모아쓰기 처리
//					// UTF-8 NFD => NFC 처리
//					// ex) ㅅㅡㅋㅡㄹㅣㄴ.txt => 스크린.txt
//					fileName = Normalizer.normalize(fileName, Normalizer.Form.NFC);
//					
//					// 파일 전송
//					filePath = uploadPath + File.separator + fileName + uploadFileTag;
//					file.transferTo(new File(filePath));
//					result.add(fileName);
//				}
//			}
//		}
//		return result;
//	}
//	
//	
//	
}
