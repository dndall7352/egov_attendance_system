package egovframework.atoz.mobile.controller;

import java.util.ArrayList;
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

import egovframework.atoz.mobile.model.AttendanceDto;
import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.UserInfoDto;
import egovframework.atoz.mobile.service.AttendanceService;
import egovframework.atoz.mobile.service.ScheduleService;
import egovframework.atoz.mobile.service.UserService;

@RestController
@RequestMapping("/user")
public class AttendanceController {
	@Autowired
	AttendanceService attendanceService;
	@Autowired
	ScheduleService scheduleService;
	@Autowired
	UserService userService;
	
	@PostMapping("/attendance.do")
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
	
	@PostMapping("/setatt.do")
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
	
	@GetMapping("/iswork.do")
	@ResponseBody
	public ResponseEntity<?> todayAttendance(@RequestParam("date") String date) throws Exception{
		System.out.println("오늘 근태 기록 조회");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserInfoDto userInfo = userService.userInfo(userDetails.getUsername());
		MyScheduleDto myScheduleDto = new MyScheduleDto();
		myScheduleDto.setEmp_number(userInfo.getEmp_number());
		myScheduleDto.setDate(date);
		String schName = scheduleService.getSchStatus(myScheduleDto);
		List<String> attName=  attendanceService.getAttStatus(myScheduleDto);
		System.out.println(attName);
		String lastAtt = null;
		
		if(!attName.isEmpty()) {
			lastAtt = attName.get(attName.size()-1);
		}
		System.out.println(lastAtt);
		System.out.println(schName);
		String statusName = null;
		List<String> buttonList = new ArrayList<String>();
		 if("출장".equals(schName) && !(attName.contains("복귀") || attName.contains("외근") || attName.contains("오후반차"))) {
			 statusName = "출장중";
			 buttonList = List.of("복귀", "외근", "오후반차");
		 }else if("휴가".equals(schName)) {
			 statusName = "휴가중";
		 }else if("출근".equals(lastAtt) || "복귀".equals(lastAtt)) {
			 statusName = "근무중";
			 buttonList = List.of("퇴근", "출장", "외근", "오전반차", "오후반차");
		 }else if("출장".equals(lastAtt)) {
			 statusName = "출장중";
			 buttonList = List.of("복귀", "외근", "오후반차");
		 }else if("외근".equals(lastAtt)) {
			 statusName = "외근중";
			 buttonList = List.of("복귀", "출장", "오후반차");
		 }else if("오후반차".equals(lastAtt)) {
			 statusName = "오후반차";
		 }else if("오전반차".equals(lastAtt)) {
			 statusName = "오전반차";
			 buttonList = List.of("복귀", "외근", "출장", "오후반차");
		 }else if("퇴근".equals(lastAtt)) {
			 statusName = "퇴근";
		 }else {
			 statusName = "출근전";
			 buttonList = List.of("출근", "출장", "외근", "오전반차");
		 }
		 System.out.println(statusName);
		 System.out.println(buttonList);
		 Map<String, Object> responseData = new HashMap<String, Object>();
		 responseData.put("statusName", statusName);
		 responseData.put("buttonList", buttonList);
		 
		return ResponseEntity.ok(responseData);
	}
	
}
