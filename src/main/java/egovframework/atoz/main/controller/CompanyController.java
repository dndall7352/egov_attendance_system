package egovframework.atoz.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.main.model.CompanyDto;
import egovframework.atoz.main.model.CompanyVo;
import egovframework.atoz.main.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	
	@GetMapping("/company")
	@ResponseBody
	public ResponseEntity<?> getCompanyInfo(@RequestParam("com_number") int com_number) throws Exception{
		System.out.println("회사 정보 불러오기");
		CompanyVo companyVo = companyService.companyInfo(com_number);
		CompanyDto companyDto = new CompanyDto(companyVo);
		return ResponseEntity.ok(companyDto);
	}
}
