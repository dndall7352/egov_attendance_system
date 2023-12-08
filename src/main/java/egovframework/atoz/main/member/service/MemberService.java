package egovframework.atoz.main.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {
	
	/*회원 등록 처리(save)*/
	public String insertMember(MemberVO vo) throws Exception;
	/*아이디 중복 확인 slelct count(*) from memeber where userid-'test1' -> count값 비교하기 때문에 int 값임*/
	public int selectMemberIdCheck(String userid) throws Exception;
	/*로그인 데이터 확인*/
	public int selectmemberCount(MemberVO vo) throws Exception;
}
