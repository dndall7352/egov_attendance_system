package egovframework.atoz.main.member.service.impl;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.atoz.main.member.service.MemberVO;

@Mapper("memberMapper")
public interface MemberMapper {
	public String insertMember(MemberVO vo) throws Exception;
	/*아이디 중복 확인 slelct count(*) from memeber where userid-'test1' -> count값 비교하기 때문에 int 값임*/
	public int selectMemberIdCheck(String userid) throws Exception;
	/*로그인 데이터 확인*/
	public int selectmemberCount(MemberVO vo) throws Exception;
}
