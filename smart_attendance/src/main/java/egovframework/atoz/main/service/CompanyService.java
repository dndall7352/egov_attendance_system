package egovframework.atoz.main.service;

import egovframework.atoz.main.model.CompanyVo;

public interface CompanyService {
	CompanyVo companyInfo(int com_number) throws Exception;
}
