package egovframework.atoz.main.authority.service;

import java.util.List;

/**
 * @Class Name : AuthorityService.java
 * @Description : Authority Business class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface AuthorityService {
	
	/**
	 * AUTHORITY을 등록한다.
	 * @param vo - 등록할 정보가 담긴 AuthorityVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertAuthority(AuthorityVO vo) throws Exception;
    
    /**
	 * AUTHORITY을 수정한다.
	 * @param vo - 수정할 정보가 담긴 AuthorityVO
	 * @return void형
	 * @exception Exception
	 */
    void updateAuthority(AuthorityVO vo) throws Exception;
    
    /**
	 * AUTHORITY을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 AuthorityVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteAuthority(AuthorityVO vo) throws Exception;
    
    /**
	 * AUTHORITY을 조회한다.
	 * @param vo - 조회할 정보가 담긴 AuthorityVO
	 * @return 조회한 AUTHORITY
	 * @exception Exception
	 */
    AuthorityVO selectAuthority(AuthorityVO vo) throws Exception;
    
    /**
	 * AUTHORITY 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return AUTHORITY 목록
	 * @exception Exception
	 */
    List selectAuthorityList(AuthorityDefaultVO searchVO) throws Exception;
    
    /**
	 * AUTHORITY 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return AUTHORITY 총 갯수
	 * @exception
	 */
    int selectAuthorityListTotCnt(AuthorityDefaultVO searchVO);
    
}
