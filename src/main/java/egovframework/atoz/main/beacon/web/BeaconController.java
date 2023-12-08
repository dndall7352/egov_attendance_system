package egovframework.atoz.main.beacon.web;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.atoz.main.authority.service.AuthorityDefaultVO;
import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconDefaultVO;
import egovframework.atoz.main.beacon.service.BeaconService;

@Controller
public class BeaconController {
	
	@Resource(name = "beaconService")
	private BeaconService beaconService;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@RequestMapping("/beacon/beaconList.do")
	public String beaconList(@ModelAttribute("searchVO") BeaconDefaultVO searchVO, 
    		ModelMap model) throws Exception{
		
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
		
        List<BeaconDTO> beaconList = beaconService.selectBeaconList(searchVO);
        model.addAttribute("resultList", beaconList);
        
        int totCnt = beaconService.selectBeaconListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
		
		return "/beacon/beacon";
	}
}
