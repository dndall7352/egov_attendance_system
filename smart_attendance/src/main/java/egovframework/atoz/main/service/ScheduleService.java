package egovframework.atoz.main.service;

import java.util.List;

import egovframework.atoz.main.model.MyScheduleDto;
import egovframework.atoz.main.model.ScheduleDto;

public interface ScheduleService {
	List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception;
}
