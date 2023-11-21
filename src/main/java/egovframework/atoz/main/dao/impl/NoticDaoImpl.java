package egovframework.atoz.main.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.dao.NoticDao;
import egovframework.atoz.main.mapper.NoticMapper;
import egovframework.atoz.main.model.NoticDto;
import egovframework.atoz.main.model.NoticPagingDto;
@Repository
public class NoticDaoImpl implements NoticDao{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<NoticDto> readNoticList(NoticPagingDto pagingDto) throws Exception {
		NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
		return mapper.readNoticList(pagingDto);
	}
	
	@Override
	public int noticAllCnt(int com_number) throws Exception {
		NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
		return mapper.noticAllCnt(com_number);
	}
}
