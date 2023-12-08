package egovframework.atoz.main.department.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.atoz.main.department.service.DepartmentDefaultVO;
import egovframework.atoz.main.department.service.DepartmentService;
import egovframework.atoz.main.department.service.DepartmentVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
/**
 * @Class Name : DepartmentServiceImpl.java
 * @Description : Department Business Implement class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("departmentService")
public class DepartmentServiceImpl extends EgovAbstractServiceImpl implements
        DepartmentService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

//    @Resource(name="departmentMapper")
//    private DepartmentMapper departmentDAO;
    
    @Resource(name="departmentDAO")
    private DepartmentDAO departmentDAO;
    
    /** ID Generation */
    //@Resource(name="{egovDepartmentIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * DEPARTMENT을 등록한다.
	 * @param vo - 등록할 정보가 담긴 DepartmentVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertDepartment(DepartmentVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	departmentDAO.insertDepartment(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * DEPARTMENT을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DepartmentVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateDepartment(DepartmentVO vo) throws Exception {
        departmentDAO.updateDepartment(vo);
    }

    /**
	 * DEPARTMENT을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 DepartmentVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteDepartment(DepartmentVO vo) throws Exception {
        departmentDAO.deleteDepartment(vo);
    }

    /**
	 * DEPARTMENT을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DepartmentVO
	 * @return 조회한 DEPARTMENT
	 * @exception Exception
	 */
    public DepartmentVO selectDepartment(DepartmentVO vo) throws Exception {
        DepartmentVO resultVO = departmentDAO.selectDepartment(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * DEPARTMENT 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT 목록
	 * @exception Exception
	 */
    public List<?> selectDepartmentList(DepartmentDefaultVO searchVO) throws Exception {
        return departmentDAO.selectDepartmentList(searchVO);
    }

    /**
	 * DEPARTMENT 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return DEPARTMENT 총 갯수
	 * @exception
	 */
    public int selectDepartmentListTotCnt(DepartmentDefaultVO searchVO) {
		return departmentDAO.selectDepartmentListTotCnt(searchVO);
	}
    
}
