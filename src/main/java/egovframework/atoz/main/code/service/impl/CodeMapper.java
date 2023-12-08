package egovframework.atoz.main.code.service.impl;

import java.util.List;


import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.code.service.CodeDefaultVO;
import egovframework.atoz.main.code.service.CodeVO;

/**
 * @Class Name : CodeMapper.java
 * @Description : Code Mapper Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("codeMapper")
public interface CodeMapper {

	/**
	 * CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CodeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertCode(CodeVO vo) throws Exception;

    /**
	 * CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CodeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCode(CodeVO vo) throws Exception;

    /**
	 * CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CodeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCode(CodeVO vo) throws Exception;

    /**
	 * CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CodeVO
	 * @return 조회한 CODE
	 * @exception Exception
	 */
    public CodeVO selectCode(CodeVO vo) throws Exception;

    /**
	 * CODE 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CODE 목록
	 * @exception Exception
	 */
    public List<CodeDefaultVO> selectCodeList(CodeDefaultVO searchVO) throws Exception;

    /**
	 * CODE 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CODE 총 갯수
	 * @exception
	 */
    public int selectCodeListTotCnt(CodeDefaultVO searchVO);

}
