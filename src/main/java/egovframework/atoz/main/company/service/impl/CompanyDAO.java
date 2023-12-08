package egovframework.atoz.main.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.company.service.CompanyDefaultVO;
import egovframework.atoz.main.company.service.CompanyVO;
import egovframework.atoz.main.department.service.impl.DepartmentMapper;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @Class Name : CompanyDAO.java
 * @Description : Company DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("companyDAO")
public class CompanyDAO{
	@Autowired
	SqlSession sqlSession;

	/**
	 * COMPANY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertCompany(CompanyVO vo) throws Exception {
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		mapper.insertCompany(vo);
    }

    /**
	 * COMPANY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCompany(CompanyVO vo) throws Exception {
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		mapper.updateCompany(vo);
    }

    /**
	 * COMPANY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCompany(CompanyVO vo) throws Exception {
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		mapper.deleteCompany(vo);
    }

    /**
	 * COMPANY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyVO
	 * @return 조회한 COMPANY
	 * @exception Exception
	 */
    public CompanyVO selectCompany(CompanyVO vo) throws Exception {
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		return mapper.selectCompany(vo);
    }

    /**
	 * COMPANY 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<CompanyDefaultVO>
	 * @return COMPANY 목록
	 * @exception Exception
	 */
    public List<CompanyDefaultVO> selectCompanyList(CompanyDefaultVO searchVO) throws Exception {
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		return mapper.selectCompanyList(searchVO);
    }

    /**
	 * COMPANY 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return COMPANY 총 갯수
	 * @exception
	 */
    public int selectCompanyListTotCnt(CompanyDefaultVO searchVO) {
        CompanyMapper mapper = sqlSession.getMapper(CompanyMapper.class);
		return mapper.selectCompanyListTotCnt(searchVO);
    }

}
