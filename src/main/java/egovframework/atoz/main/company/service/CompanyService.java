package egovframework.atoz.main.company.service;

import java.util.List;

import egovframework.atoz.main.company.service.CompanyDefaultVO;
import egovframework.atoz.main.company.service.CompanyVO;

/**
 * @Class Name : CompanyService.java
 * @Description : Company Business class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface CompanyService {
	
	/**
	 * COMPANY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertCompany(CompanyVO vo) throws Exception;
    
    /**
	 * COMPANY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyVO
	 * @return void형
	 * @exception Exception
	 */
    void updateCompany(CompanyVO vo) throws Exception;
    
    /**
	 * COMPANY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteCompany(CompanyVO vo) throws Exception;
    
    /**
	 * COMPANY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyVO
	 * @return 조회한 COMPANY
	 * @exception Exception
	 */
    CompanyVO selectCompany(CompanyVO vo) throws Exception;
    
    /**
	 * COMPANY 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY 목록
	 * @exception Exception
	 */
    List selectCompanyList(CompanyDefaultVO searchVO) throws Exception;
    
    /**
	 * COMPANY 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY 총 갯수
	 * @exception
	 */
    int selectCompanyListTotCnt(CompanyDefaultVO searchVO);
    
}
