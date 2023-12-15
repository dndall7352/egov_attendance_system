package egovframework.atoz.main.page.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeaderController {
	
	@RequestMapping("/systemAdmin/getHeader.do")
	public String sysGetHeader(@RequestParam String pageName, Model model)throws Exception{
		System.out.println(pageName);
		model.addAttribute("pageName", pageName);
		
		return "/header/system_admin_header";
	}
	
	@RequestMapping("/companyAdmin/getHeader.do")
	public String comGetHeader(@RequestParam String pageName, Model model) throws Exception{
		model.addAttribute("pageName", pageName);
		return "/header/company_admin_header";
	}
}
