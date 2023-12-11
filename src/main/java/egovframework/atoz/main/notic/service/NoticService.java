package egovframework.atoz.main.notic.service;
import java.util.List;

/**
 * @Class Name : NoticService.java
 * @Description : Notic Business class
 * @Modification Information
 *
 * @author kke
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface NoticService {
	
	/**
	 * NOTIC을 등록한다.
	 * @param vo - 등록할 정보가 담긴 NoticVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertNotic(NoticVO vo) throws Exception;
    
    /**
	 * NOTIC을 수정한다.
	 * @param vo - 수정할 정보가 담긴 NoticVO
	 * @return void형
	 * @exception Exception
	 */
    void updateNotic(NoticVO vo) throws Exception;
    
    /**
	 * NOTIC을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 NoticVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteNotic(NoticVO vo) throws Exception;
    
    /**
	 * NOTIC을 조회한다.
	 * @param vo - 조회할 정보가 담긴 NoticVO
	 * @return 조회한 NOTIC
	 * @exception Exception
	 */
    NoticVO selectNotic(NoticVO vo) throws Exception;
    
    /**
	 * NOTIC 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return NOTIC 목록
	 * @exception Exception
	 */
    List selectNoticList(NoticDefaultVO searchVO) throws Exception;
    
    /**
	 * NOTIC 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return NOTIC 총 갯수
	 * @exception
	 */
    int selectNoticListTotCnt(NoticDefaultVO searchVO);
    
}
