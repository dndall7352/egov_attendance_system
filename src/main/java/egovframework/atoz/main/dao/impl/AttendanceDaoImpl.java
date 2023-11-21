package egovframework.atoz.main.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.dao.AttendanceDao;
import egovframework.atoz.main.mapper.AttendanceMapper;
import egovframework.atoz.main.model.AttendanceDto;
import egovframework.atoz.main.model.MyScheduleDto;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<AttendanceDto> myAttendance(MyScheduleDto dto) throws Exception {
		AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
		return mapper.myAttendance(dto);
	}
	
	@Override
	public int setAttendance(AttendanceDto dto) throws Exception {
		AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
		return mapper.setAttendance(dto);
	}
	
	@Override
	public List<AttendanceDto> todayAttendance(MyScheduleDto dto) throws Exception {
		AttendanceMapper mapper = sqlSession.getMapper(AttendanceMapper.class);
		return mapper.todayAttendance(dto);
	}
}
