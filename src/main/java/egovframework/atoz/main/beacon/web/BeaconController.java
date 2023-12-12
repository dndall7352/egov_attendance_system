package egovframework.atoz.main.beacon.web;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.main.authority.service.AuthorityDefaultVO;
import egovframework.atoz.main.beacon.service.BeaconDTO;
import egovframework.atoz.main.beacon.service.BeaconDefaultVO;
import egovframework.atoz.main.beacon.service.BeaconService;
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
    	return beaconList(cri, model);
    }
    
	@RequestMapping("/beaconList.do")
	public String beaconList(Criteria cri, Model model) throws Exception{
		
        List<BeaconDTO> beaconList = beaconService.selectBeaconList(cri);
        int totalCnt = beaconService.selectBeaconListTotCnt(cri);
        System.out.println(beaconList);
        model.addAttribute("beaconList", beaconList);
        model.addAttribute("pageVO", new PageVO(cri, totalCnt));

		return "/beacon/beacon";
	}
	
	@RequestMapping("/selectBeacon.do")
	public String selectBeacon(@RequestParam int beaconNumber, Model model) throws Exception{
		System.out.println("beacon detail number : " + beaconNumber);
		BeaconDTO beaconDTO = beaconService.selectBeacon(beaconNumber);
		
		model.addAttribute("beaconDTO", beaconDTO);
		return "/beacon/beacon_select";
	}
}
