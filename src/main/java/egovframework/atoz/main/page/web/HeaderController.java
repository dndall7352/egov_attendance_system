package egovframework.atoz.main.page.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HeaderController {
	
	@RequestMapping("systemAdmin/getHeader.do")
	public String getHeader(@RequestParam String pageName, Model model)throws Exception{
		System.out.println(pageName);
		model.addAttribute("pageName", pageName);
		
		return "system_admin_header";
	}
}
