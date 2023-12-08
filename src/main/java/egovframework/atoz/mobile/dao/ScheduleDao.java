package egovframework.atoz.mobile.dao;

import java.util.List;

import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.ScheduleDto;

public interface ScheduleDao {
	List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception;
	String getSchStatus(MyScheduleDto dto) throws Exception;
}
