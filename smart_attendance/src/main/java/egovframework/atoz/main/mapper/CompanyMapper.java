package egovframework.atoz.main.mapper;

import egovframework.atoz.main.model.CompanyVo;

public interface CompanyMapper {
	CompanyVo companyInfo(int com_number) throws Exception;
}
