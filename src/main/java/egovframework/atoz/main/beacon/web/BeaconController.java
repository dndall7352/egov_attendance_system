package egovframework.atoz.main.beacon.web;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconService;
import egovframework.atoz.main.beacon.service.SearchCompanyDTO;
import egovframework.atoz.main.page.Criteria;
import egovframework.atoz.main.page.PageVO;

@Controller
@RequestMapping("/beacon")
public class BeaconController {
	
	@Resource(name = "beaconService")
	private BeaconService beaconService;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    @RequestMapping("/beacon.do")
    public String beacon(Model model)throws Exception{
    	Criteria cri = new Criteria();
    	return beaconList(cri, 0, model);
    }
    
	@RequestMapping("/beaconList.do")
	public String beaconList(Criteria cri, @RequestParam(name="beacon_number", required = false)Integer beacon_number, Model model) throws Exception{
		
        List<BeaconDTO> beaconList = beaconService.selectBeaconList(cri);
        int totalCnt = beaconService.selectBeaconListTotCnt(cri);
        System.out.println(beaconList);
        model.addAttribute("beaconList", beaconList);
        model.addAttribute("pageVO", new PageVO(cri, totalCnt));
        model.addAttribute("beacon_number", beacon_number);
        model.addAttribute("cnt", totalCnt);
		return "/beacon/beacon";
	}
	
	@RequestMapping("/selectBeacon.do")
	public String selectBeacon(@RequestParam int beaconNumber, Model model) throws Exception{
		System.out.println("beacon detail number : " + beaconNumber);
		BeaconDTO beaconDTO = beaconService.selectBeacon(beaconNumber);
		
		model.addAttribute("beaconDTO", beaconDTO);
		return "/beacon/beacon_select";
	}
	
	@PostMapping("/searchCompany.do")
	@ResponseBody
	public ResponseEntity<?> searchConpany(@RequestBody Map<String, String> requestBody) throws Exception{
		System.out.println(requestBody);
		List<SearchCompanyDTO> resultList = beaconService.searchCompany(requestBody);
		int cnt = resultList.size();
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("cnt", cnt);
		searchInfo.put("resultList", resultList);
		return ResponseEntity.ok(searchInfo);
	}
	
	@PostMapping("/updateBeacon.do")
	public String updateBeacon(@ModelAttribute BeaconDTO beaconDTO,@ModelAttribute Criteria cri, Model model) throws Exception{
		System.out.println(beaconDTO);
		System.out.println(cri);
		
		int cnt = beaconService.updateBeacon(beaconDTO);
		String encodedSearchName = URLEncoder.encode(cri.getSearchName(), "UTF-8");
		if(cnt > 0) {
			String redirectUrl = "/beacon/beaconList.do?pageNum=" + cri.getPageNum() + "&amount=" + cri.getAmount() + "&searchType=" + cri.getSearchType() + "&searchName=" + encodedSearchName + "&beacon_number=" + beaconDTO.getBeacon_number();
			model.addAttribute("alertMessage", "저장되었습니다.");
			model.addAttribute("redirectUrl", redirectUrl);
			 return "/beacon/alertPage";
		}
		return null;
	}
	
	@RequestMapping("/insertJspPage.do")
	public String insertJspPage()throws Exception{
		return "/beacon/beacon_insert";
	}
	
	@RequestMapping("/insertBeacon.do")
	public String insertBeacon(@ModelAttribute BeaconDTO beaconDTO, Model model) throws Exception{
		int cnt = beaconService.insertBeacon(beaconDTO);
		if(cnt > 0) {
			String redirectUrl = "/beacon/beaconList.do";
			model.addAttribute("alertMessage", "저장되었습니다.");
			model.addAttribute("redirectUrl", redirectUrl);
			return "/beacon/alertPage";
		}
		return null;
	}
	
	@RequestMapping("/printBeacon.do")
	public String printBeacon(Criteria cri, Model model)throws Exception{
		System.out.println(cri);
		List<BeaconDTO> beaconList = beaconService.printBeacon(cri);
		model.addAttribute("beaconList", beaconList);
		model.addAttribute("cri", cri);
		model.addAttribute("cnt", beaconList.size());
		return "/beacon/beacon_print";
	}
	
	@RequestMapping("/searchCompanyList.do")
	public ResponseEntity<?> searchCompanyList() throws Exception{
		List<SearchCompanyDTO> resultList = beaconService.searchCompanyList();
		int cnt = resultList.size();
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("cnt", cnt);
		searchInfo.put("resultList", resultList);
		return ResponseEntity.ok(searchInfo);
	}

}
