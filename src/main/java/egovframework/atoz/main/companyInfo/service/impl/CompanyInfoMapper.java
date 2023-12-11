package egovframework.atoz.main.companyInfo.service.impl;

import java.util.List;


import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.companyInfo.service.CompanyInfoDefaultVO;
import egovframework.atoz.main.companyInfo.service.CompanyInfoVO;

/**
 * @Class Name : CompanyInfoMapper.java
 * @Description : CompanyInfo Mapper Class
 * @Modification Information
 *
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("companyInfoMapper")
public interface CompanyInfoMapper {

	/**
	 * COMPANY_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertCompanyInfo(CompanyInfoVO vo) throws Exception;

    /**
	 * COMPANY_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCompanyInfo(CompanyInfoVO vo) throws Exception;

    /**
	 * COMPANY_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCompanyInfo(CompanyInfoVO vo) throws Exception;

    /**
	 * COMPANY_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyInfoVO
	 * @return 조회한 COMPANY_INFO
	 * @exception Exception
	 */
    public CompanyInfoVO selectCompanyInfo(CompanyInfoVO vo) throws Exception;

    /**
	 * COMPANY_INFO 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return COMPANY_INFO 목록
	 * @exception Exception
	 */
    public List<CompanyInfoDefaultVO> selectCompanyInfoList(CompanyInfoDefaultVO searchVO) throws Exception;

    /**
     * BEACON의 사용 수를 조회한다
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return COMPANY_INFO 목록
     * @exception Exception
     */
	public List<?> selectBeaconCount(CompanyInfoVO vo);
	
	/**
     * EMPLOYEE의 사용 수를 조회한다
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return COMPANY_INFO 목록
     * @exception Exception
     */
	public List<?> selectEmployeeCount(CompanyInfoVO vo);
	
    /**
	 * COMPANY_INFO 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return COMPANY_INFO 총 갯수
	 * @exception
	 */
    public int selectCompanyInfoListTotCnt(CompanyInfoDefaultVO searchVO);

	


    

}
