package egovframework.atoz.main.code.service;

import java.util.List;

/**
 * @Class Name : CodeService.java
 * @Description : Code Business class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface CodeService {
	
	/**
	 * CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CodeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertCode(CodeVO vo) throws Exception;
    
    /**
	 * CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CodeVO
	 * @return void형
	 * @exception Exception
	 */
    void updateCode(CodeVO vo) throws Exception;
    
    /**
	 * CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CodeVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteCode(CodeVO vo) throws Exception;
    
    /**
	 * CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CodeVO
	 * @return 조회한 CODE
	 * @exception Exception
	 */
    CodeVO selectCode(CodeVO vo) throws Exception;
    
    /**
	 * CODE 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CODE 목록
	 * @exception Exception
	 */
    List selectCodeList(CodeDefaultVO searchVO) throws Exception;
    
    /**
	 * CODE 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return CODE 총 갯수
	 * @exception
	 */
    int selectCodeListTotCnt(CodeDefaultVO searchVO);
    
}
