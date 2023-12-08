package egovframework.atoz.main.department.service;

import java.util.List;

/**
 * @Class Name : DepartmentService.java
 * @Description : Department Business class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface DepartmentService {
	
	/**
	 * DEPARTMENT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertDepartment(DepartmentVO vo) throws Exception;
    
    /**
	 * DEPARTMENT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentVO
	 * @return void형
	 * @exception Exception
	 */
    void updateDepartment(DepartmentVO vo) throws Exception;
    
    /**
	 * DEPARTMENT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteDepartment(DepartmentVO vo) throws Exception;
    
    /**
	 * DEPARTMENT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentVO
	 * @return 조회한 DEPARTMENT
	 * @exception Exception
	 */
    DepartmentVO selectDepartment(DepartmentVO vo) throws Exception;
    
    /**
	 * DEPARTMENT 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT 목록
	 * @exception Exception
	 */
    List selectDepartmentList(DepartmentDefaultVO searchVO) throws Exception;
    
    /**
	 * DEPARTMENT 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT 총 갯수
	 * @exception
	 */
    int selectDepartmentListTotCnt(DepartmentDefaultVO searchVO);
}
