package egovframework.atoz.main.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.egovframe.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.member.service.MemberVO;


@Repository("memberDAO")
public class MemberDAO{
	@Autowired
	SqlSession sqlSession;

	public String insertMember(MemberVO vo) throws Exception{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return (String)mapper.insertMember(vo);
	}

	public int selectMemberIdCheck(String userid) throws Exception{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return (int) mapper.selectMemberIdCheck(userid);  //ㅇ클래스이름.메소드 이름, return값=숫자 =int
	}

	public int selectmemberCount(MemberVO vo) throws Exception{
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		return (int) mapper.selectmemberCount(vo);
	}



}
