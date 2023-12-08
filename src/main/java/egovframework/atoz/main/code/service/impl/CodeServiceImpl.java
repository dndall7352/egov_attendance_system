package egovframework.atoz.main.code.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.atoz.main.code.service.CodeDefaultVO;
import egovframework.atoz.main.code.service.CodeService;
import egovframework.atoz.main.code.service.CodeVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
/**
 * @Class Name : CodeServiceImpl.java
 * @Description : Code Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("codeService")
public class CodeServiceImpl extends EgovAbstractServiceImpl implements
        CodeService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeServiceImpl.class);

    @Resource(name="codeDAO")
    private CodeDAO codeDAO;
    
    //@Resource(name="codeDAO")
    //private CodeDAO codeDAO;
    
    /** ID Generation */
    //@Resource(name="{egovCodeIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CodeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertCode(CodeVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	codeDAO.insertCode(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CodeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCode(CodeVO vo) throws Exception {
        codeDAO.updateCode(vo);
    }

    /**
	 * CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CodeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCode(CodeVO vo) throws Exception {
        codeDAO.deleteCode(vo);
    }

    /**
	 * CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CodeVO
	 * @return 조회한 CODE
	 * @exception Exception
	 */
    public CodeVO selectCode(CodeVO vo) throws Exception {
        CodeVO resultVO = codeDAO.selectCode(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * CODE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CODE 목록
	 * @exception Exception
	 */
    public List<?> selectCodeList(CodeDefaultVO searchVO) throws Exception {
        return codeDAO.selectCodeList(searchVO);
    }

    /**
	 * CODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CODE 총 갯수
	 * @exception
	 */
    public int selectCodeListTotCnt(CodeDefaultVO searchVO) {
		return codeDAO.selectCodeListTotCnt(searchVO);
	}
    
}
