package egovframework.atoz.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.atoz.main.dao.AttendanceDao;
import egovframework.atoz.main.model.AttendanceDto;
import egovframework.atoz.main.model.MyScheduleDto;
import egovframework.atoz.main.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceDao attendanceDao;
	
	@Override
	public List<AttendanceDto> myAttendance(MyScheduleDto dto) throws Exception {
		return attendanceDao.myAttendance(dto);
	}
	
	@Override
	public int setAttendance(AttendanceDto dto) throws Exception {
		return attendanceDao.setAttendance(dto);
	}
	
	@Override
	public List<AttendanceDto> todayAttendance(MyScheduleDto dto) throws Exception {
		return attendanceDao.todayAttendance(dto);
	}
	@Override
	public List<String> getAttStatus(MyScheduleDto dto) throws Exception {
		return attendanceDao.getAttStatus(dto);
	}
}
