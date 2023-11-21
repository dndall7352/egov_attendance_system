package egovframework.atoz.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.main.model.AttendanceDto;
import egovframework.atoz.main.model.MyScheduleDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.service.AttendanceService;
import egovframework.atoz.main.service.UserService;

@RestController
@RequestMapping("/user")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	UserService userService;
	
	@PostMapping("/attendance")
	@ResponseBody
	public ResponseEntity<?> getAttendance(@RequestBody Map<String, String> requestBody) throws Exception{
		System.out.println("근태 기록 불러오기");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserInfoDto userInfo = userService.userInfo(userDetails.getUsername());
		MyScheduleDto myScheduleDto = new MyScheduleDto();
		myScheduleDto.setEmp_number(userInfo.getEmp_number());
		myScheduleDto.setDate(requestBody.get("date"));
		
		List<AttendanceDto> attendanceDto = attendanceService.myAttendance(myScheduleDto);
		
		return ResponseEntity.ok(attendanceDto);
	}
	
	@PostMapping("/setatt")
	@ResponseBody
	public ResponseEntity<?> setAttendance(@RequestBody AttendanceDto attendanceDto) throws Exception{
		System.out.println("근태 기록 저장하기");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserInfoDto userInfo = userService.userInfo(userDetails.getUsername());

		attendanceDto.setAtt_name(attendanceDto.getAtt_name());
		attendanceDto.setConnet_code(attendanceDto.getConnet_code());
		attendanceDto.setDep_name(userInfo.getDep_name());
		attendanceDto.setEmp_number(userInfo.getEmp_number());
		
		int cnt = attendanceService.setAttendance(attendanceDto);
		if(cnt > 0) {
			return new ResponseEntity(cnt, HttpStatus.CREATED);
		}else {
			return new ResponseEntity(cnt, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/iswork")
	@ResponseBody
	public ResponseEntity<?> todayAttendance(@RequestParam("date") String date) throws Exception{
		System.out.println("오늘 근태 기록 조회");
		boolean isWork = false;
		boolean isClicked = false;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserInfoDto userInfo = userService.userInfo(userDetails.getUsername());
		
		MyScheduleDto myScheduleDto = new MyScheduleDto();
		myScheduleDto.setEmp_number(userInfo.getEmp_number());
		myScheduleDto.setDate(date);
		
		List<AttendanceDto> todayAttendanceList = attendanceService.todayAttendance(myScheduleDto);
		
		for(AttendanceDto item : todayAttendanceList) {
			if(item.getAtt_name().equals("출근")) {
				isWork = true;
			}else if(item.getAtt_name().equals("퇴근")) {
				isClicked = true;
			}
		}
		Map<String, Boolean> isCheck = new HashMap<String, Boolean>();
		isCheck.put("isWork", isWork);
		isCheck.put("isClicked", isClicked);
		return ResponseEntity.ok(isCheck);
	}
	
}
