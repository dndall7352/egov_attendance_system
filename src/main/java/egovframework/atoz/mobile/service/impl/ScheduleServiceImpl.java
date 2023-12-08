package egovframework.atoz.mobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.atoz.mobile.dao.ScheduleDao;
import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.ScheduleDto;
import egovframework.atoz.mobile.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	ScheduleDao scheduleDao;
	
	@Override
	public List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception {
		return scheduleDao.mySchedule(dto);
	}
	@Override
	public String getSchStatus(MyScheduleDto dto) throws Exception {
		return scheduleDao.getSchStatus(dto);
	}
}
