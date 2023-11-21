package egovframework.atoz.main.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.main.model.NoticDto;
import egovframework.atoz.main.model.NoticPagingDto;
import egovframework.atoz.main.security.JwtTokenProvider;
import egovframework.atoz.main.service.NoticService;
import egovframework.atoz.main.service.ScheduleService;
import egovframework.atoz.main.service.UserService;

@RestController
public class NoticController {
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	NoticService noticService;
	
	
	@GetMapping("/user/notic")
	@ResponseBody
	public ResponseEntity<?> readNoticLisst(@RequestParam(name = "com_number") int com_number,
											@RequestParam(name = "page") int page) throws Exception {
		System.out.println("공자사항 페이지 불러오기" + page);
		NoticPagingDto pagingDto = new NoticPagingDto(page, com_number);
		List<NoticDto> noticList = noticService.readNoticList(pagingDto);
		
		if(noticList != null) {
			return ResponseEntity.ok(noticList);
		}
		return ResponseEntity.ok(null);
	}
	
	
	@GetMapping("/user/notic/count")
	@ResponseBody
	public ResponseEntity<?> noticAllCnt(@RequestParam(name = "com_number") int com_number) throws Exception {
		System.out.println("공자사항 개수 가져오기");
		int cnt = noticService.noticAllCnt(com_number);
		
		if(cnt >= 0) {
			return ResponseEntity.ok(cnt);
		}
		return ResponseEntity.ok(null);
	}

}
