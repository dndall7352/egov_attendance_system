package egovframework.atoz.main.companyInfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.companyInfo.service.CompanyInfoDefaultVO;
import egovframework.atoz.main.companyInfo.service.CompanyInfoVO;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @Class Name : CompanyInfoDAO.java
 * @Description : CompanyInfo DAO Class
 * @Modification Information
 *
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("companyInfoDAO")
public class CompanyInfoDAO {
	@Autowired
	SqlSession sqlSession;

	/**
	 * COMPANY_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertCompanyInfo(CompanyInfoVO vo) throws Exception {
    	CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
    	mapper.insertCompanyInfo(vo);
    }

    /**
	 * COMPANY_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCompanyInfo(CompanyInfoVO vo) throws Exception {
        CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
    	mapper.updateCompanyInfo(vo);
    }

    /**
	 * COMPANY_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCompanyInfo(CompanyInfoVO vo) throws Exception {
        CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
    	mapper.deleteCompanyInfo(vo);
    }

    /**
	 * COMPANY_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyInfoVO
	 * @return 조회한 COMPANY_INFO
	 * @exception Exception
	 */
    public CompanyInfoVO selectCompanyInfo(CompanyInfoVO vo) throws Exception {
        CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
    	return mapper.selectCompanyInfo(vo);
    }

    /**
	 * COMPANY_INFO 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<CompanyInfoDefaultVO>
	 * @return COMPANY_INFO 목록
	 * @exception Exception
	 */
    public List<CompanyInfoDefaultVO> selectCompanyInfoList(CompanyInfoDefaultVO searchVO) throws Exception {
        CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
    	return mapper.selectCompanyInfoList(searchVO);
    }

    /**
	 * COMPANY_INFO 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return COMPANY_INFO 총 갯수
	 * @exception
	 */
    public int selectCompanyInfoListTotCnt(CompanyInfoDefaultVO searchVO) {
        CompanyInfoMapper mapper = sqlSession.getMapper(CompanyInfoMapper.class);
    	return mapper.selectCompanyInfoListTotCnt(searchVO);
    }

}
