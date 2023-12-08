package egovframework.atoz.mobile.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.ScheduleDto;
import egovframework.atoz.mobile.model.UserInfoDto;
import egovframework.atoz.mobile.model.UserVo;
import egovframework.atoz.mobile.security.JwtTokenProvider;
import egovframework.atoz.mobile.service.ScheduleService;
import egovframework.atoz.mobile.service.UserService;

@RestController
public class ScheduleController {
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	UserService userService;
	@Autowired
	ScheduleService scheduleService;
	
	@PostMapping("/user/schedule.do")
	public ResponseEntity<List<ScheduleDto>> getSchedule(@RequestBody Map<String, String> requestBody) throws Exception{
		System.out.println("date");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		UserInfoDto userInfo = userService.userInfo(userDetails.getUsername());
		
		MyScheduleDto myScheduleDto = new MyScheduleDto();
		myScheduleDto.setEmp_number(userInfo.getEmp_number());
		myScheduleDto.setDate(requestBody.get("date"));

		List<ScheduleDto> myScheduleList = scheduleService.mySchedule(myScheduleDto);

		return ResponseEntity.ok(myScheduleList);
	}
}
