package egovframework.atoz.main.authority.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.authority.service.AuthorityDefaultVO;
import egovframework.atoz.main.authority.service.AuthorityVO;

import org.apache.ibatis.session.SqlSession;

/**
 * @Class Name : AuthorityDAO.java
 * @Description : Authority DAO Class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("authorityDAO")
public class AuthorityDAO{
	@Autowired
	SqlSession sqlSession;
	/**
	 * AUTHORITY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 AuthorityVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertAuthority(AuthorityVO vo) throws Exception {
        AuthorityMapper mapper = sqlSession.getMapper(AuthorityMapper.class);
		mapper.insertAuthority(vo);
    }

    /**
	 * AUTHORITY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 AuthorityVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateAuthority(AuthorityVO vo) throws Exception {
        AuthorityMapper mapper = sqlSession.getMapper(AuthorityMapper.class);
		mapper.updateAuthority(vo);
    }

    /**
	 * AUTHORITY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 AuthorityVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteAuthority(AuthorityVO vo) throws Exception {
        AuthorityMapper mapper = sqlSession.getMapper(AuthorityMapper.class);
		mapper.deleteAuthority(vo);
    }

    /**
	 * AUTHORITY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 AuthorityVO
	 * @return 조회한 AUTHORITY
	 * @exception Exception
	 */
    public AuthorityVO selectAuthority(AuthorityVO vo) throws Exception {
        AuthorityMapper mapper = sqlSession.getMapper(AuthorityMapper.class);
		return mapper.selectAuthority(vo);
    }

    /**
	 * AUTHORITY 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 List<AuthorityDefaultVO>
	 * @return AUTHORITY 목록
	 * @exception Exception
	 */
    public List<AuthorityDefaultVO> selectAuthorityList(AuthorityDefaultVO searchVO) throws Exception {
        AuthorityMapper mapper = sqlSession.getMapper(AuthorityMapper.class);
		return mapper.selectAuthorityList(searchVO);
    }

    /**
	 * AUTHORITY 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return AUTHORITY 총 갯수
	 * @exception
	 */
    public int selectAuthorityListTotCnt(AuthorityDefaultVO searchVO) {
        AuthorityMapper mapper = sqlSession.getMapper(AuthorityMapper.class);
		return mapper.selectAuthorityListTotCnt(searchVO);
    }

}
