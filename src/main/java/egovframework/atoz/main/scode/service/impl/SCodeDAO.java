package egovframework.atoz.main.scode.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.department.service.impl.DepartmentMapper;
import egovframework.atoz.main.scode.service.SCodeVO;


@Repository("sCodeDAO")
public class SCodeDAO{
	@Autowired
	SqlSession sqlSession;
	
	// 아이바틱스와 연결 == sql와 연결
	public String insertSGroupCode(SCodeVO vo) throws Exception {
		SCodeMapper mapper = sqlSession.getMapper(SCodeMapper.class);
		return (String)mapper.insertSGroupCode(vo);
	}

	public List<?> selectSGroupCodeList(SCodeVO vo) throws Exception {
		SCodeMapper mapper = sqlSession.getMapper(SCodeMapper.class);
		return mapper.selectSGroupCodeList(vo);
	}

	public SCodeVO selectSCodeWriteAndList(int code_group) throws Exception {
		SCodeMapper mapper = sqlSession.getMapper(SCodeMapper.class);
		return mapper.selectSCodeWriteAndList(code_group);
		
	}

	public String insertSCode(SCodeVO vo) throws Exception {
		SCodeMapper mapper = sqlSession.getMapper(SCodeMapper.class);
		return (String) mapper.insertSCode(vo);
	}

	public List<?> selectSCodeList(SCodeVO vo) throws Exception {
		SCodeMapper mapper = sqlSession.getMapper(SCodeMapper.class);
		return mapper.selectSCodeList(vo);
	}

}
