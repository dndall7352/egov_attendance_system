package egovframework.atoz.main.code.web;

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

import egovframework.atoz.main.code.service.CodeDefaultVO;
import egovframework.atoz.main.code.service.CodeService;
import egovframework.atoz.main.code.service.CodeVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : CodeController.java
 * @Description : Code Controller class
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
@SessionAttributes(types=CodeVO.class)
public class CodeController {

    @Resource(name = "codeService")
    private CodeService codeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * CODE 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 CodeDefaultVO
	 * @return "/code/CodeList"
	 * @exception Exception
	 */
    @RequestMapping(value="/code/CodeList.do")
    public String selectCodeList(@ModelAttribute("searchVO") CodeDefaultVO searchVO, 
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
		
        List<?> codeList = codeService.selectCodeList(searchVO);
        model.addAttribute("resultList", codeList);
        
        int totCnt = codeService.selectCodeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/code/CodeList";
    } 
    
    @RequestMapping("/code/addCodeView.do")
    public String addCodeView(
            @ModelAttribute("searchVO") CodeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("codeVO", new CodeVO());
        return "/code/CodeRegister";
    }
    
    @RequestMapping("/code/addCode.do")
    public String addCode(
            CodeVO codeVO,
            @ModelAttribute("searchVO") CodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        codeService.insertCode(codeVO);
        System.out.println("데이터 추가");
        status.setComplete();
        return "forward:/code/CodeList.do";
    }
    
    @RequestMapping("/code/updateCodeView.do")
    public String updateCodeView(
            @RequestParam("code") java.math.BigDecimal code ,
            @ModelAttribute("searchVO") CodeDefaultVO searchVO, Model model)
            throws Exception {
        CodeVO codeVO = new CodeVO();
        codeVO.setCode(code);
        // 변수명은 CoC 에 따라 codeVO
        model.addAttribute(selectCode(codeVO, searchVO));
        return "/code/CodeRegister";
    }

    @RequestMapping("/code/selectCode.do")
    public @ModelAttribute("codeVO")
    CodeVO selectCode(
            CodeVO codeVO,
            @ModelAttribute("searchVO") CodeDefaultVO searchVO) throws Exception {
        System.out.println("불러오기");
    	return codeService.selectCode(codeVO);
    }

    @RequestMapping("/code/updateCode.do")
    public String updateCode(
            CodeVO codeVO,
            @ModelAttribute("searchVO") CodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        codeService.updateCode(codeVO);
        status.setComplete();
        return "forward:/code/CodeList.do";
    }
    
    @RequestMapping("/code/deleteCode.do")
    public String deleteCode(
            CodeVO codeVO,
            @ModelAttribute("searchVO") CodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        codeService.deleteCode(codeVO);
        status.setComplete();
        return "forward:/code/CodeList.do";
    }

}
