package egovframework.atoz.main.dao;

import egovframework.atoz.main.model.CompanyVo;

public interface CompanyDao {
	CompanyVo companyInfo(int com_number) throws Exception;
}
