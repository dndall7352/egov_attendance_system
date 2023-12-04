package egovframework.atoz.main.mapper;

import java.util.List;

import egovframework.atoz.main.model.MyScheduleDto;
import egovframework.atoz.main.model.ScheduleDto;

public interface ScheduleMapper {
	List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception;
	String getSchStatus(MyScheduleDto dto) throws Exception;
}
