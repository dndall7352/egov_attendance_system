package egovframework.atoz.main.scode.service;

import java.util.List;

public interface SCodeService {
	/*
	 * SGroupCode 저장하기
	 */
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
