package egovframework.atoz.main.department.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.department.service.DepartmentDefaultVO;
import egovframework.atoz.main.department.service.DepartmentVO;

import org.apache.ibatis.session.SqlSession;

/**
 * @Class Name : DepartmentDAO.java
 * @Description : Department DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("departmentDAO")
public class DepartmentDAO{

	@Autowired
	SqlSession sqlSession;
	/**
	 * DEPARTMENT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDepartment(DepartmentVO vo) throws Exception {
    	DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		mapper.insertDepartment(vo);
    }

    /**
	 * DEPARTMENT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDepartment(DepartmentVO vo) throws Exception {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		mapper.updateDepartment(vo);
    }

    /**
	 * DEPARTMENT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDepartment(DepartmentVO vo) throws Exception {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		mapper.deleteDepartment(vo);
    }

    /**
	 * DEPARTMENT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentVO
	 * @return 조회한 DEPARTMENT
	 * @exception Exception
	 */
    public DepartmentVO selectDepartment(DepartmentVO vo) throws Exception {
    	DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		return (DepartmentVO)mapper.selectDepartment(vo);
    }

    /**
	 * DEPARTMENT 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<DepartmentDefaultVO>
	 * @return DEPARTMENT 목록
	 * @exception Exception
	 */
    public List<DepartmentDefaultVO> selectDepartmentList(DepartmentDefaultVO searchVO) throws Exception {
    	DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		return mapper.selectDepartmentList(searchVO);
    }

    /**
	 * DEPARTMENT 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPARTMENT 총 갯수
	 * @exception
	 */
    public int selectDepartmentListTotCnt(DepartmentDefaultVO searchVO) {
    	DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
		return mapper.selectDepartmentListTotCnt(searchVO);
    }

}
