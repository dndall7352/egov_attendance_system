package egovframework.atoz.main.authority.web;

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

import egovframework.atoz.main.authority.service.AuthorityDefaultVO;
import egovframework.atoz.main.authority.service.AuthorityService;
import egovframework.atoz.main.authority.service.AuthorityVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : AuthorityController.java
 * @Description : Authority Controller class
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
@SessionAttributes(types=AuthorityVO.class)
public class AuthorityController {

    @Resource(name = "authorityService")
    private AuthorityService authorityService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * AUTHORITY 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 AuthorityDefaultVO
	 * @return "/authority/AuthorityList"
	 * @exception Exception
	 */
    @RequestMapping(value="/authority/AuthorityList.do")
    public String selectAuthorityList(@ModelAttribute("searchVO") AuthorityDefaultVO searchVO, 
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
		
        List<?> authorityList = authorityService.selectAuthorityList(searchVO);
        model.addAttribute("resultList", authorityList);
        
        int totCnt = authorityService.selectAuthorityListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/authority/AuthorityList";
    } 
    
    @RequestMapping("/authority/addAuthorityView.do")
    public String addAuthorityView(
            @ModelAttribute("searchVO") AuthorityDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("authorityVO", new AuthorityVO());
        return "/authority/AuthorityRegister";
    }
    
    @RequestMapping("/authority/addAuthority.do")
    public String addAuthority(
            AuthorityVO authorityVO,
            @ModelAttribute("searchVO") AuthorityDefaultVO searchVO, SessionStatus status)
            throws Exception {
        authorityService.insertAuthority(authorityVO);
        status.setComplete();
        return "forward:/authority/AuthorityList.do";
    }
    
    @RequestMapping("/authority/updateAuthorityView.do")
    public String updateAuthorityView(
            @RequestParam("autNumber") java.math.BigDecimal autNumber ,
            @ModelAttribute("searchVO") AuthorityDefaultVO searchVO, Model model)
            throws Exception {
        AuthorityVO authorityVO = new AuthorityVO();
        authorityVO.setAutNumber(autNumber);
        // 변수명은 CoC 에 따라 authorityVO
        model.addAttribute(selectAuthority(authorityVO, searchVO));
        return "/authority/AuthorityRegister";
    }

    @RequestMapping("/authority/selectAuthority.do")
    public @ModelAttribute("authorityVO")
    AuthorityVO selectAuthority(
            AuthorityVO authorityVO,
            @ModelAttribute("searchVO") AuthorityDefaultVO searchVO) throws Exception {
        return authorityService.selectAuthority(authorityVO);
    }

    @RequestMapping("/authority/updateAuthority.do")
    public String updateAuthority(
            AuthorityVO authorityVO,
            @ModelAttribute("searchVO") AuthorityDefaultVO searchVO, SessionStatus status)
            throws Exception {
        authorityService.updateAuthority(authorityVO);
        status.setComplete();
        return "forward:/authority/AuthorityList.do";
    }
    
    @RequestMapping("/authority/deleteAuthority.do")
    public String deleteAuthority(
            AuthorityVO authorityVO,
            @ModelAttribute("searchVO") AuthorityDefaultVO searchVO, SessionStatus status)
            throws Exception {
        authorityService.deleteAuthority(authorityVO);
        status.setComplete();
        return "forward:/authority/AuthorityList.do";
    }

}
