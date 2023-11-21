package egovframework.atoz.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.atoz.main.dao.CompanyDao;
import egovframework.atoz.main.model.CompanyVo;
import egovframework.atoz.main.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyDao companyDao;
	
	@Override
	public CompanyVo companyInfo(int com_number) throws Exception {
		return companyDao.companyInfo(com_number);
	}

}
