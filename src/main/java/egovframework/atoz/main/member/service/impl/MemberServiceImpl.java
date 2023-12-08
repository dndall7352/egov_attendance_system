package egovframework.atoz.main.member.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.atoz.main.member.service.MemberService;
import egovframework.atoz.main.member.service.MemberVO;


@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="memberDAO")
	public MemberDAO memberDAO;
	
	@Override  // 다형성 ds
	public String insertMember(MemberVO vo) throws Exception {
		return memberDAO.insertMember(vo);  // 리소스 선언을 했으므로 연결. 멤버DAO는 SQL과 연결 / 상황: 사용자가 저장을 눌렀을 때의 상황
	}

	@Override
	public int selectMemberIdCheck(String userid) throws Exception {
		return memberDAO.selectMemberIdCheck(userid);
	}

	@Override
	public int selectmemberCount(MemberVO vo) throws Exception {
		return memberDAO.selectmemberCount(vo);
	}

}
