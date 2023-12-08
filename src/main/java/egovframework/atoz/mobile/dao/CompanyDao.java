package egovframework.atoz.mobile.dao;

import egovframework.atoz.mobile.model.CompanyVo;

public interface CompanyDao {
	CompanyVo companyInfo(int com_number) throws Exception;
}
