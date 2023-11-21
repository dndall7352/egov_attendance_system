package egovframework.atoz.main.mapper;

import java.util.List;

import egovframework.atoz.main.model.AttendanceDto;
import egovframework.atoz.main.model.MyScheduleDto;

public interface AttendanceMapper {
	List<AttendanceDto> myAttendance(MyScheduleDto dto) throws Exception;
	int setAttendance(AttendanceDto dto) throws Exception; 
	List<AttendanceDto> todayAttendance(MyScheduleDto dto) throws Exception;
}
