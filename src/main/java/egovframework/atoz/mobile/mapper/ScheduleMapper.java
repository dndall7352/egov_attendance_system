package egovframework.atoz.mobile.mapper;

import java.util.List;

import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.ScheduleDto;

public interface ScheduleMapper {
	List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception;
	String getSchStatus(MyScheduleDto dto) throws Exception;
}
