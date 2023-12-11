package egovframework.atoz.main.notic.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.notic.service.NoticDefaultVO;
import egovframework.atoz.main.notic.service.NoticVO;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;


/**
 * @Class Name : NoticDAO.java
 * @Description : Notic DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("noticDAO")
public class NoticDAO{
	@Autowired
	SqlSession sqlSession;

	/**
	 * NOTIC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertNotic(NoticVO vo) throws Exception {
    	NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
        mapper.insertNotic(vo);
    }

    /**
	 * NOTIC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateNotic(NoticVO vo) throws Exception {
        NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
        mapper.updateNotic(vo);
    }

    /**
	 * NOTIC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteNotic(NoticVO vo) throws Exception {
        NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
        mapper.deleteNotic(vo);
    }

    /**
	 * NOTIC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticVO
	 * @return 조회한 NOTIC
	 * @exception Exception
	 */
    public NoticVO selectNotic(NoticVO vo) throws Exception {
        NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
        return mapper.selectNotic(vo);
    }

    /**
	 * NOTIC 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<NoticDefaultVO>
	 * @return NOTIC 목록
	 * @exception Exception
	 */
    public List<NoticDefaultVO> selectNoticList(NoticDefaultVO searchVO) throws Exception {
        NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
        return mapper.selectNoticList(searchVO);
    }

    /**
	 * NOTIC 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return NOTIC 총 갯수
	 * @exception
	 */
    public int selectNoticListTotCnt(NoticDefaultVO searchVO) {
        NoticMapper mapper = sqlSession.getMapper(NoticMapper.class);
        return mapper.selectNoticListTotCnt(searchVO);
    }

}
