package egovframework.atoz.main.companyInfo.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import egovframework.atoz.main.companyInfo.service.CompanyInfoDefaultVO;
import egovframework.atoz.main.companyInfo.service.CompanyInfoService;
import egovframework.atoz.main.companyInfo.service.CompanyInfoVO;

import org.apache.commons.io.FilenameUtils;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name : CompanyInfoController.java
 * @Description : CompanyInfo Controller class
 * @Modification Information
 *
 * @author johj
 * @since 2023-12-07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=CompanyInfoVO.class)
public class CompanyInfoController {

    @Resource(name = "companyInfoService")
    private CompanyInfoService companyInfoService;
    
//    String paths = "\\home\\atoz\\upload\\";
    String paths = "C:/resources/company/";
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * COMPANY_INFO 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 CompanyInfoDefaultVO
	 * @return "/companyInfo/CompanyInfoList"
	 * @exception Exception
	 */
    @RequestMapping(value="/companyInfo/CompanyInfoList.do")
    public String selectCompanyInfoList( @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, 
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
		
        List<?> companyInfoList = companyInfoService.selectCompanyInfoList(searchVO);
        model.addAttribute("resultList", companyInfoList);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(companyInfoList);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        
        int totCnt = companyInfoService.selectCompanyInfoListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        
        return "/companyInfo/CompanyInfoList";
    } 
    
 // 파일 반환
    @RequestMapping(value = "fileDownload.do")
    public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String filename = request.getParameter("fileName");
       String realFilename = "";
       System.out.println(filename);

       try {
          String browser = request.getHeader("User-Agent");
          // 파일 인코딩
          if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
             filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
          } else {
             filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
          }
       } catch (UnsupportedEncodingException e) {
          System.out.println("UnsupportedEncodingException 발생");
       }

       realFilename = paths + filename;
       System.out.println(realFilename);
       File file = new File(realFilename);
       if (!file.exists()) {
          return;
       }

       // 파일명 지정
       response.setContentType("application/octer-stream");
       response.setHeader("Content-Transfer-Encoding", "binary");
       response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

       try {
          OutputStream os = response.getOutputStream();
          FileInputStream fis = new FileInputStream(realFilename);
          int cnt = 0;
          byte[] bytes = new byte[512];
          while ((cnt = fis.read(bytes)) != -1) {
             os.write(bytes, 0, cnt);
          }
          fis.close();
          os.close();
       } catch (Exception e) {
          e.printStackTrace();
       }

    }
    
    @RequestMapping("/companyInfo/addCompanyInfoView.do")
    public String addCompanyInfoView(
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, Model model)
            throws Exception {
    	
        model.addAttribute("companyInfoVO", new CompanyInfoVO());
        return "/companyInfo/CompanyInfoRegister";
    }
    
    @RequestMapping("/companyInfo/addCompanyInfo.do")
    public String addCompanyInfo(CompanyInfoVO companyInfoVO, @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, SessionStatus status) throws Exception {
    	String fileName = null;
		MultipartFile uploadFile = companyInfoVO.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String originalFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName); // 확장자 구하기
			UUID uuid = UUID.randomUUID(); // UUID 구하기
			fileName = uuid + "." + ext;
			uploadFile.transferTo(new File(paths + fileName));

		}
		companyInfoVO.setFileName(fileName);

		System.out.println(companyInfoVO.getFileName());

		try {
			companyInfoService.insertCompanyInfo(companyInfoVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        status.setComplete();
        return "forward:/companyInfo/CompanyInfoList.do";
    }
    
    @RequestMapping("/companyInfo/updateCompanyInfoView.do")
    public String updateCompanyInfoView(
            @RequestParam("comNumber") java.math.BigDecimal comNumber ,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, Model model)
            throws Exception {
        CompanyInfoVO companyInfoVO = new CompanyInfoVO();
        companyInfoVO.setComNumber(comNumber);
        // 변수명은 CoC 에 따라 companyInfoVO
        model.addAttribute(selectCompanyInfo(companyInfoVO, searchVO));
        return "/companyInfo/CompanyInfoRegister";
    }

    @RequestMapping("/companyInfo/selectCompanyInfo.do")
    public @ModelAttribute("companyInfoVO")
    CompanyInfoVO selectCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO) throws Exception {
        return companyInfoService.selectCompanyInfo(companyInfoVO);
    }

    @RequestMapping("/companyInfo/updateCompanyInfo.do")
    public String updateCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyInfoService.updateCompanyInfo(companyInfoVO);
        status.setComplete();
        return "forward:/companyInfo/CompanyInfoList.do";
    }
    
    @RequestMapping("/companyInfo/deleteCompanyInfo.do")
    public String deleteCompanyInfo(
            CompanyInfoVO companyInfoVO,
            @ModelAttribute("searchVO") CompanyInfoDefaultVO searchVO, SessionStatus status)
            throws Exception {
        companyInfoService.deleteCompanyInfo(companyInfoVO);
        status.setComplete();
        return "forward:/companyInfo/CompanyInfoList.do";
    }

}
