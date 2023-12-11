package egovframework.atoz.main.notic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.atoz.main.notic.service.NoticDefaultVO;
import egovframework.atoz.main.notic.service.NoticService;
import egovframework.atoz.main.notic.service.NoticVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

/**
 * @Class Name : NoticServiceImpl.java
 * @Description : Notic Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("noticService")
public class NoticServiceImpl extends EgovAbstractServiceImpl implements
        NoticService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(NoticServiceImpl.class);

    @Resource(name="noticDAO")
    private NoticDAO noticDAO;
    
    //@Resource(name="noticDAO")
    //private NoticDAO noticDAO;
    
    /** ID Generation */
    //@Resource(name="{egovNoticIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * NOTIC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertNotic(NoticVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	noticDAO.insertNotic(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * NOTIC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateNotic(NoticVO vo) throws Exception {
        noticDAO.updateNotic(vo);
    }

    /**
	 * NOTIC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteNotic(NoticVO vo) throws Exception {
        noticDAO.deleteNotic(vo);
    }

    /**
	 * NOTIC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticVO
	 * @return 조회한 NOTIC
	 * @exception Exception
	 */
    public NoticVO selectNotic(NoticVO vo) throws Exception {
        NoticVO resultVO = noticDAO.selectNotic(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * NOTIC 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return NOTIC 목록
	 * @exception Exception
	 */
    public List<?> selectNoticList(NoticDefaultVO searchVO) throws Exception {
        return noticDAO.selectNoticList(searchVO);
    }

    /**
	 * NOTIC 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return NOTIC 총 갯수
	 * @exception
	 */
    public int selectNoticListTotCnt(NoticDefaultVO searchVO) {
		return noticDAO.selectNoticListTotCnt(searchVO);
	}
    
}
