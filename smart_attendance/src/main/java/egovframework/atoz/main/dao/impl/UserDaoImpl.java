package egovframework.atoz.main.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.main.dao.UserDao;
import egovframework.atoz.main.mapper.UserMapper;
import egovframework.atoz.main.model.UserConfirmDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.model.UserLoginDto;
import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public UserInfoDto userConfirm(UserConfirmDto dto) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.userConfirm(dto);
	}

	@Override
	public int pwUpdate(UserVo userVO) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.pwUpdate(userVO);
	}

	@Override
	public UserInfoDto userInfo(String emp_number) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.userInfo(emp_number);
	}

	@Override
	public UserVo loginCheck(UserLoginDto userLoginDto) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.loginCheck(userLoginDto);
	}

	@Override
	public UserDto findByEno(String emp_number) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.findByEno(emp_number);
	}
	
	@Override
	public UserVo decodeToken(String emp_number) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.decodeToken(emp_number);
	}
}