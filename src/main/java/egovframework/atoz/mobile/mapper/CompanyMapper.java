package egovframework.atoz.mobile.mapper;

import egovframework.atoz.mobile.model.CompanyVo;

public interface CompanyMapper {
	CompanyVo companyInfo(int com_number) throws Exception;
}
