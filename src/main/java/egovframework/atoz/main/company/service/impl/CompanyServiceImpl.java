package egovframework.atoz.main.company.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

import egovframework.atoz.main.company.service.CompanyDefaultVO;
import egovframework.atoz.main.company.service.CompanyService;
import egovframework.atoz.main.company.service.CompanyVO;
import egovframework.atoz.main.company.service.impl.CompanyDAO;
import egovframework.atoz.main.company.service.impl.CompanyMapper;

/**
 * @Class Name : CompanyServiceImpl.java
 * @Description : Company Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("companyService")
public class CompanyServiceImpl extends EgovAbstractServiceImpl implements
        CompanyService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Resource(name="companyDAO")
    private CompanyDAO companyDAO;
    
    //@Resource(name="companyDAO")
    //private CompanyDAO companyDAO;
    
    /** ID Generation */
    //@Resource(name="{egovCompanyIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * COMPANY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertCompany(CompanyVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	companyDAO.insertCompany(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * COMPANY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCompany(CompanyVO vo) throws Exception {
        companyDAO.updateCompany(vo);
    }

    /**
	 * COMPANY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCompany(CompanyVO vo) throws Exception {
        companyDAO.deleteCompany(vo);
    }

    /**
	 * COMPANY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyVO
	 * @return 조회한 COMPANY
	 * @exception Exception
	 */
    public CompanyVO selectCompany(CompanyVO vo) throws Exception {
        CompanyVO resultVO = companyDAO.selectCompany(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * COMPANY 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY 목록
	 * @exception Exception
	 */
    public List<?> selectCompanyList(CompanyDefaultVO searchVO) throws Exception {
        return companyDAO.selectCompanyList(searchVO);
    }

    /**
	 * COMPANY 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY 총 갯수
	 * @exception
	 */
    public int selectCompanyListTotCnt(CompanyDefaultVO searchVO) {
		return companyDAO.selectCompanyListTotCnt(searchVO);
	}
    
}
