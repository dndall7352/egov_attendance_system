package egovframework.atoz.main.scode.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.scode.service.SCodeVO;

@Mapper("sCodeMapper")
public interface SCodeMapper {
	public String insertSGroupCode(SCodeVO vo) throws Exception;

	/*
	 * SGroupCode 화면 목록
	 */
	public List<?> selectSGroupCodeList(SCodeVO vo) throws Exception;

	/*
	 * SGroupCode 디테일
	 */
	public SCodeVO selectSCodeWriteAndList(int code_group) throws Exception;

	/*
	 * SGroupCode 값 추가
	 */
	public String insertSCode(SCodeVO vo) throws Exception;

	/*
	 * SGroupCode 화면 목록
	 */
	public List<?> selectSCodeList(SCodeVO vo) throws Exception;
}
