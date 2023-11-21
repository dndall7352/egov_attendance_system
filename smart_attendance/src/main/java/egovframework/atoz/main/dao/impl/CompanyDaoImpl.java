package egovframework.atoz.main.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.dao.CompanyDao;
import egovframework.atoz.main.mapper.CompanyMapper;
import egovframework.atoz.main.model.CompanyVo;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	@Autowired
	SqlSession session;
	
	@Override
	public CompanyVo companyInfo(int com_number) throws Exception {
		CompanyMapper mapper = session.getMapper(CompanyMapper.class);
		return mapper.companyInfo(com_number);
	}

}
