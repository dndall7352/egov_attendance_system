package egovframework.atoz.main.notic.web;

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

import egovframework.atoz.main.notic.service.NoticDefaultVO;
import egovframework.atoz.main.notic.service.NoticService;
import egovframework.atoz.main.notic.service.NoticVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : NoticController.java
 * @Description : Notic Controller class
 * @Modification Information
 *
 * @author kke
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=NoticVO.class)
public class NoticController {

    @Resource(name = "noticService")
    private NoticService noticService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * NOTIC 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 NoticDefaultVO
	 * @return "/notic/NoticList"
	 * @exception Exception
	 */
    @RequestMapping(value="/notic/NoticList.do")
    public String selectNoticList(@ModelAttribute("searchVO") NoticDefaultVO searchVO, 
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
		
        List<?> noticList = noticService.selectNoticList(searchVO);
        model.addAttribute("resultList", noticList);
        
        int totCnt = noticService.selectNoticListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/notic/NoticList";
    } 
    
    @RequestMapping("/notic/addNoticView.do")
    public String addNoticView(
            @ModelAttribute("searchVO") NoticDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("noticVO", new NoticVO());
        return "/notic/NoticRegister";
    }
    
    @RequestMapping("/notic/addNotic.do")
    public String addNotic(
            NoticVO noticVO,
            @ModelAttribute("searchVO") NoticDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticService.insertNotic(noticVO);
        status.setComplete();
        return "forward:/notic/NoticList.do";
    }
    
    @RequestMapping("/notic/updateNoticView.do")
    public String updateNoticView(
            @RequestParam("num") java.math.BigDecimal num ,
            @ModelAttribute("searchVO") NoticDefaultVO searchVO, Model model)
            throws Exception {
        NoticVO noticVO = new NoticVO();
        noticVO.setNum(num);
        // 변수명은 CoC 에 따라 noticVO
        model.addAttribute(selectNotic(noticVO, searchVO));
        return "/notic/NoticRegister";
    }

    @RequestMapping("/notic/selectNotic.do")
    public @ModelAttribute("noticVO")
    NoticVO selectNotic(
            NoticVO noticVO,
            @ModelAttribute("searchVO") NoticDefaultVO searchVO) throws Exception {
        return noticService.selectNotic(noticVO);
    }

    @RequestMapping("/notic/updateNotic.do")
    public String updateNotic(
            NoticVO noticVO,
            @ModelAttribute("searchVO") NoticDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticService.updateNotic(noticVO);
        status.setComplete();
        return "forward:/notic/NoticList.do";
    }
    
    @RequestMapping("/notic/deleteNotic.do")
    public String deleteNotic(
            NoticVO noticVO,
            @ModelAttribute("searchVO") NoticDefaultVO searchVO, SessionStatus status)
            throws Exception {
        noticService.deleteNotic(noticVO);
        status.setComplete();
        return "forward:/notic/NoticList.do";
    }
    
    @RequestMapping("/notic/NoticList2.do")
	public String NoticWrite() {
		// 기업관리자 List화면
		return "notic/NoticList2";
	}

}
