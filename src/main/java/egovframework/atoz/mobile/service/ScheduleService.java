package egovframework.atoz.mobile.service;

import java.util.List;

import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.ScheduleDto;

public interface ScheduleService {
	List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception;
	String getSchStatus(MyScheduleDto dto) throws Exception;
}
