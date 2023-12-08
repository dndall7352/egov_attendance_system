package egovframework.atoz.mobile.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.mobile.dao.ScheduleDao;
import egovframework.atoz.mobile.mapper.ScheduleMapper;
import egovframework.atoz.mobile.model.MyScheduleDto;
import egovframework.atoz.mobile.model.ScheduleDto;

@Repository
public class ScheduleDaoImpl implements ScheduleDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.mySchedule(dto);
	}
	@Override
	public String getSchStatus(MyScheduleDto dto) throws Exception {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.getSchStatus(dto);
	}
}
