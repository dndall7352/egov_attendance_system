package egovframework.atoz.mobile.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.atoz.mobile.dao.CompanyDao;
import egovframework.atoz.mobile.model.CompanyVo;
import egovframework.atoz.mobile.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyDao companyDao;
	
	@Override
	public CompanyVo companyInfo(int com_number) throws Exception {
		return companyDao.companyInfo(com_number);
	}

}
