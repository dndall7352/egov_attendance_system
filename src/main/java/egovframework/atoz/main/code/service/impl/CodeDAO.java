package egovframework.atoz.main.code.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.code.service.CodeDefaultVO;
import egovframework.atoz.main.code.service.CodeVO;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;


/**
 * @Class Name : CodeDAO.java
 * @Description : Code DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("codeDAO")
public class CodeDAO{

	@Autowired
	SqlSession sqlSession;
	/**
	 * CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 CodeVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertCode(CodeVO vo) throws Exception {
    	CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);
		mapper.insertCode(vo);
    }

    /**
	 * CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 CodeVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateCode(CodeVO vo) throws Exception {
        CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);
		mapper.updateCode(vo);
    }

    /**
	 * CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 CodeVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteCode(CodeVO vo) throws Exception {
        CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);
		mapper.deleteCode(vo);
    }

    /**
	 * CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 CodeVO
	 * @return 조회한 CODE
	 * @exception Exception
	 */
    public CodeVO selectCode(CodeVO vo) throws Exception {
        CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);
		return mapper.selectCode(vo);
    }

    /**
	 * CODE 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<CodeDefaultVO>
	 * @return CODE 목록
	 * @exception Exception
	 */
    public List<CodeDefaultVO> selectCodeList(CodeDefaultVO searchVO) throws Exception {
        CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);
		return mapper.selectCodeList(searchVO);
    }

    /**
	 * CODE 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CODE 총 갯수
	 * @exception
	 */
    public int selectCodeListTotCnt(CodeDefaultVO searchVO) {
        CodeMapper mapper = sqlSession.getMapper(CodeMapper.class);
		return mapper.selectCodeListTotCnt(searchVO);
    }

}
