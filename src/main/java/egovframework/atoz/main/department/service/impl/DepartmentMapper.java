package egovframework.atoz.main.department.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.department.service.DepartmentDefaultVO;
import egovframework.atoz.main.department.service.DepartmentVO;

/**
 * @Class Name : DepartmentMapper.java
 * @Description : Department Mapper Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("departmentMapper")
public interface DepartmentMapper {

	/**
	 * DEPARTMENT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertDepartment(DepartmentVO vo) throws Exception;

    /**
	 * DEPARTMENT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDepartment(DepartmentVO vo) throws Exception;

    /**
	 * DEPARTMENT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDepartment(DepartmentVO vo) throws Exception;

    /**
	 * DEPARTMENT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentVO
	 * @return 조회한 DEPARTMENT
	 * @exception Exception
	 */
    public DepartmentVO selectDepartment(DepartmentVO vo) throws Exception;

    /**
	 * DEPARTMENT 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPARTMENT 목록
	 * @exception Exception
	 */
    public List<DepartmentDefaultVO> selectDepartmentList(DepartmentDefaultVO searchVO) throws Exception;

    /**
	 * DEPARTMENT 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DEPARTMENT 총 갯수
	 * @exception
	 */
    public int selectDepartmentListTotCnt(DepartmentDefaultVO searchVO);
    

}
