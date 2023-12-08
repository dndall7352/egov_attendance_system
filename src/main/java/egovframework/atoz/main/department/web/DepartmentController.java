package egovframework.atoz.main.department.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.atoz.main.department.service.DepartmentDefaultVO;
import egovframework.atoz.main.department.service.DepartmentService;
import egovframework.atoz.main.department.service.DepartmentVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : DepartmentController.java
 * @Description : Department Controller class
 * @Modification Information
 *
 * @author kke
 * @since 23-12-04
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=DepartmentVO.class)
public class DepartmentController {

    @Resource(name = "departmentService")
    private DepartmentService departmentService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * DEPARTMENT 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 DepartmentDefaultVO
	 * @return "/department/DepartmentList"
	 * @exception Exception
	 */
    @RequestMapping(value="/department/DepartmentList.do")
    public String selectDepartmentList(@ModelAttribute("searchVO") DepartmentDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> departmentList = departmentService.selectDepartmentList(searchVO);
        model.addAttribute("resultList", departmentList);
        
        int totCnt = departmentService.selectDepartmentListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        System.out.println(departmentList);
        return "/department/DepartmentList";
    } 
    
    @RequestMapping("/department/addDepartmentView.do")
    public String addDepartmentView(
            @ModelAttribute("searchVO") DepartmentDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("departmentVO", new DepartmentVO());
        return "/department/DepartmentRegister";
    }
    
    @RequestMapping("/department/addDepartment.do")
    public String addDepartment(
            DepartmentVO departmentVO,
            @ModelAttribute("searchVO") DepartmentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        departmentService.insertDepartment(departmentVO);
        status.setComplete();
        return "forward:/department/DepartmentList.do";
    }
    
    @RequestMapping("/department/updateDepartmentView.do")
    public String updateDepartmentView(
            @RequestParam("depNumber") java.math.BigDecimal depNumber ,
            @ModelAttribute("searchVO") DepartmentDefaultVO searchVO, Model model)
            throws Exception {
    	System.out.println(depNumber);
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setDepNumber(depNumber);
        // 변수명은 CoC 에 따라 departmentVO
        model.addAttribute(selectDepartment(departmentVO, searchVO));
        return "/department/DepartmentRegister";
    }

    @RequestMapping("/department/selectDepartment.do")
    public @ModelAttribute("departmentVO")
    DepartmentVO selectDepartment(
            DepartmentVO departmentVO,
            @ModelAttribute("searchVO") DepartmentDefaultVO searchVO) throws Exception {
    	System.out.println("해당 부서 선택");
    	DepartmentVO resultVO = departmentService.selectDepartment(departmentVO);
    	System.out.println(resultVO);
        return resultVO;
    }

    @RequestMapping("/department/updateDepartment.do")
    public String updateDepartment(
            DepartmentVO departmentVO,
            @ModelAttribute("searchVO") DepartmentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        departmentService.updateDepartment(departmentVO);
        status.setComplete();
        return "forward:/department/DepartmentList.do";
    }
    
    @RequestMapping("/department/deleteDepartment.do")
    public String deleteDepartment(
            DepartmentVO departmentVO,
            @ModelAttribute("searchVO") DepartmentDefaultVO searchVO, SessionStatus status)
            throws Exception {
        departmentService.deleteDepartment(departmentVO);
        status.setComplete();
        return "forward:/department/DepartmentList.do";
    }

}
