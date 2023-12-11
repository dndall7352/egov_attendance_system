package egovframework.atoz.main.companyInfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.atoz.main.companyInfo.service.CompanyInfoDefaultVO;
import egovframework.atoz.main.companyInfo.service.CompanyInfoService;
import egovframework.atoz.main.companyInfo.service.CompanyInfoVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

/**
 * @Class Name : CompanyInfoServiceImpl.java
 * @Description : CompanyInfo Business Implement class
 * @Modification Information
 *
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("companyInfoService")
public class CompanyInfoServiceImpl extends EgovAbstractServiceImpl implements
        CompanyInfoService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyInfoServiceImpl.class);

    @Resource(name="companyInfoDAO")
    private CompanyInfoDAO companyInfoDAO;
    
    //@Resource(name="companyInfoDAO")
    //private CompanyInfoDAO companyInfoDAO;
    
    /** ID Generation */
    //@Resource(name="{egovCompanyInfoIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * COMPANY_INFO을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CompanyInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertCompanyInfo(CompanyInfoVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	companyInfoDAO.insertCompanyInfo(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * COMPANY_INFO을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CompanyInfoVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCompanyInfo(CompanyInfoVO vo) throws Exception {
        companyInfoDAO.updateCompanyInfo(vo);
    }

    /**
	 * COMPANY_INFO을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CompanyInfoVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCompanyInfo(CompanyInfoVO vo) throws Exception {
        companyInfoDAO.deleteCompanyInfo(vo);
    }

    /**
	 * COMPANY_INFO을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CompanyInfoVO
	 * @return 조회한 COMPANY_INFO
	 * @exception Exception
	 */
    public CompanyInfoVO selectCompanyInfo(CompanyInfoVO vo) throws Exception {
        CompanyInfoVO resultVO = companyInfoDAO.selectCompanyInfo(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * COMPANY_INFO 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY_INFO 목록
	 * @exception Exception
	 */
    public List<?> selectCompanyInfoList(CompanyInfoDefaultVO searchVO) throws Exception {
        return companyInfoDAO.selectCompanyInfoList(searchVO);
    }
    
    /**
	 * COMPANY_INFO 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return COMPANY_INFO 총 갯수
	 * @exception
	 */
    public int selectCompanyInfoListTotCnt(CompanyInfoDefaultVO searchVO) {
		return companyInfoDAO.selectCompanyInfoListTotCnt(searchVO);
	}

	

	
    
}
