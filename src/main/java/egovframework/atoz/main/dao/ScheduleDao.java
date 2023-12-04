package egovframework.atoz.main.dao;

import java.util.List;

import egovframework.atoz.main.model.MyScheduleDto;
import egovframework.atoz.main.model.ScheduleDto;

public interface ScheduleDao {
	List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception;
	String getSchStatus(MyScheduleDto dto) throws Exception;
}
