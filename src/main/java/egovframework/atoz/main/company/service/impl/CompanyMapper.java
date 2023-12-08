package egovframework.atoz.main.company.service.impl;

import java.util.List;


import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.company.service.CompanyDefaultVO;
import egovframework.atoz.main.company.service.CompanyVO;

/**
 * @Class Name : CompanyMapper.java
 * @Description : Company Mapper Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("companyMapper")
public interface CompanyMapper {

	/**
	 * COMPANY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertCompany(CompanyVO vo) throws Exception;

    /**
	 * COMPANY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCompany(CompanyVO vo) throws Exception;

    /**
	 * COMPANY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCompany(CompanyVO vo) throws Exception;

    /**
	 * COMPANY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyVO
	 * @return 조회한 COMPANY
	 * @exception Exception
	 */
    public CompanyVO selectCompany(CompanyVO vo) throws Exception;

    /**
	 * COMPANY 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return COMPANY 목록
	 * @exception Exception
	 */
    public List<CompanyDefaultVO> selectCompanyList(CompanyDefaultVO searchVO) throws Exception;

    /**
	 * COMPANY 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return COMPANY 총 갯수
	 * @exception
	 */
    public int selectCompanyListTotCnt(CompanyDefaultVO searchVO);

}
