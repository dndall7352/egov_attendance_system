package egovframework.atoz.main.company.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.atoz.main.company.service.CompanyDefaultVO;
import egovframework.atoz.main.company.service.CompanyService;
import egovframework.atoz.main.company.service.CompanyVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : CompanyController.java
 * @Description : Company Controller class
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
@SessionAttributes(types=CompanyVO.class)
public class CompanyController {

    @Resource(name = "companyService")
    private CompanyService companyService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * COMPANY 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 CompanyDefaultVO
	 * @return "/company/CompanyList"
	 * @exception Exception
	 */
    @RequestMapping(value="/company/CompanyList.do")
    public String selectCompanyList(@ModelAttribute("searchVO") CompanyDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	System.out.println("기업 리스트 불러오기");
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
		
        List<CompanyDefaultVO> companyList = companyService.selectCompanyList(searchVO);
        model.addAttribute("resultList", companyList);
        
        int totCnt = companyService.selectCompanyListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/company/CompanyList";
    } 
    
    @RequestMapping("/company/addCompanyView.do")
    public String addCompanyView(
            @ModelAttribute("searchVO") CompanyDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("companyVO", new CompanyVO());
        return "/company/CompanyRegister";
    }
    
    @RequestMapping("/company/addCompany.do")
    public String addCompany(
            CompanyVO companyVO,
            @ModelAttribute("searchVO") CompanyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyService.insertCompany(companyVO);
        status.setComplete();
        return "forward:/company/CompanyList.do";
    }
    
    @RequestMapping("/company/updateCompanyView.do")
    public String updateCompanyView(
            @RequestParam("comNumber") java.math.BigDecimal comNumber ,
            @ModelAttribute("searchVO") CompanyDefaultVO searchVO, Model model)
            throws Exception {
        CompanyVO companyVO = new CompanyVO();
        companyVO.setComNumber(comNumber);
        // 변수명은 CoC 에 따라 companyVO
        model.addAttribute(selectCompany(companyVO, searchVO));
        return "/company/CompanyRegister";
    }

    @RequestMapping("/company/selectCompany.do")
    public @ModelAttribute("companyVO")
    CompanyVO selectCompany(
            CompanyVO companyVO,
            @ModelAttribute("searchVO") CompanyDefaultVO searchVO) throws Exception {
        return companyService.selectCompany(companyVO);
    }

    @RequestMapping("/company/updateCompany.do")
    public String updateCompany(
            CompanyVO companyVO,
            @ModelAttribute("searchVO") CompanyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyService.updateCompany(companyVO);
        status.setComplete();
        return "forward:/company/CompanyList.do";
    }
    
    @RequestMapping("/company/deleteCompany.do")
    public String deleteCompany(
            CompanyVO companyVO,
            @ModelAttribute("searchVO") CompanyDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyService.deleteCompany(companyVO);
        status.setComplete();
        return "forward:/company/CompanyList.do";
    }

}
