package egovframework.atoz.main.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.dao.ScheduleDao;
import egovframework.atoz.main.mapper.ScheduleMapper;
import egovframework.atoz.main.model.MyScheduleDto;
import egovframework.atoz.main.model.ScheduleDto;

@Repository
public class ScheduleDaoImpl implements ScheduleDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<ScheduleDto> mySchedule(MyScheduleDto dto) throws Exception {
		ScheduleMapper mapper = sqlSession.getMapper(ScheduleMapper.class);
		return mapper.mySchedule(dto);
	}
}
