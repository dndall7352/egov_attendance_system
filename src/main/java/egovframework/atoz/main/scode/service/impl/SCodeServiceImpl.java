package egovframework.atoz.main.scode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.atoz.main.scode.service.SCodeService;
import egovframework.atoz.main.scode.service.SCodeVO;


@Service("sCodeService")
public class SCodeServiceImpl implements SCodeService {

	@Resource(name = "sCodeDAO")
	private SCodeDAO sCodeDAO;

	@Override
	public String insertSGroupCode(SCodeVO vo) throws Exception {
		return (String) sCodeDAO.insertSGroupCode(vo);
	}

	@Override
	public List<?> selectSGroupCodeList(SCodeVO vo) throws Exception {
		return sCodeDAO.selectSGroupCodeList(vo);
	}

	@Override
	public SCodeVO selectSCodeWriteAndList(int code_group) throws Exception {
		return sCodeDAO.selectSCodeWriteAndList(code_group);
	}

	@Override
	public String insertSCode(SCodeVO vo) throws Exception {
		return (String) sCodeDAO.insertSCode(vo);
	}

	@Override
	public List<?> selectSCodeList(SCodeVO vo) throws Exception {
		return sCodeDAO.selectSCodeList(vo);
	}
	
}
