package egovframework.atoz.main.companyInfo.service;

import java.util.List;

/**
 * @Class Name : CompanyInfoService.java
 * @Description : CompanyInfo Business class
 * @Modification Information
 *
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface CompanyInfoService {
	
	/**
	 * COMPANY_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertCompanyInfo(CompanyInfoVO vo) throws Exception;
    
    /**
	 * COMPANY_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyInfoVO
	 * @return void형
	 * @exception Exception
	 */
    void updateCompanyInfo(CompanyInfoVO vo) throws Exception;
    
    /**
	 * COMPANY_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteCompanyInfo(CompanyInfoVO vo) throws Exception;
    
    /**
	 * COMPANY_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyInfoVO
	 * @return 조회한 COMPANY_INFO
	 * @exception Exception
	 */
    CompanyInfoVO selectCompanyInfo(CompanyInfoVO vo) throws Exception;
    
    /**
	 * COMPANY_INFO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY_INFO 목록
	 * @exception Exception
	 */
    List selectCompanyInfoList(CompanyInfoDefaultVO searchVO) throws Exception;
    
    /**
	 * COMPANY_INFO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY_INFO 총 갯수
	 * @exception
	 */
    int selectCompanyInfoListTotCnt(CompanyInfoDefaultVO searchVO);
    
}
