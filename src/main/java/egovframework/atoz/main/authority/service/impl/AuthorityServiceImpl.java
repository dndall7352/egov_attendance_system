package egovframework.atoz.main.authority.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.atoz.main.authority.service.AuthorityDefaultVO;
import egovframework.atoz.main.authority.service.AuthorityService;
import egovframework.atoz.main.authority.service.AuthorityVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

/**
 * @Class Name : AuthorityServiceImpl.java
 * @Description : Authority Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("authorityService")
public class AuthorityServiceImpl extends EgovAbstractServiceImpl implements
        AuthorityService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityServiceImpl.class);

    @Resource(name="authorityDAO")
    private AuthorityDAO authorityDAO;
    
    //@Resource(name="authorityDAO")
    //private AuthorityDAO authorityDAO;
    
    /** ID Generation */
    //@Resource(name="{egovAuthorityIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * AUTHORITY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 AuthorityVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertAuthority(AuthorityVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	authorityDAO.insertAuthority(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * AUTHORITY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 AuthorityVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateAuthority(AuthorityVO vo) throws Exception {
        authorityDAO.updateAuthority(vo);
    }

    /**
	 * AUTHORITY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 AuthorityVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteAuthority(AuthorityVO vo) throws Exception {
        authorityDAO.deleteAuthority(vo);
    }

    /**
	 * AUTHORITY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 AuthorityVO
	 * @return 조회한 AUTHORITY
	 * @exception Exception
	 */
    public AuthorityVO selectAuthority(AuthorityVO vo) throws Exception {
        AuthorityVO resultVO = authorityDAO.selectAuthority(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * AUTHORITY 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return AUTHORITY 목록
	 * @exception Exception
	 */
    public List<?> selectAuthorityList(AuthorityDefaultVO searchVO) throws Exception {
        return authorityDAO.selectAuthorityList(searchVO);
    }

    /**
	 * AUTHORITY 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return AUTHORITY 총 갯수
	 * @exception
	 */
    public int selectAuthorityListTotCnt(AuthorityDefaultVO searchVO) {
		return authorityDAO.selectAuthorityListTotCnt(searchVO);
	}
    
}
