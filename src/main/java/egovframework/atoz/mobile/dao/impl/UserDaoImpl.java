package egovframework.atoz.mobile.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import egovframework.atoz.mobile.dao.UserDao;
import egovframework.atoz.mobile.mapper.UserMapper;
import egovframework.atoz.mobile.model.UserConfirmDto;
import egovframework.atoz.mobile.model.UserInfoDto;
import egovframework.atoz.mobile.model.UserLoginDto;
import egovframework.atoz.mobile.model.UserVo;
import egovframework.atoz.mobile.security.UserDto;

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
	public int pwUpdate(UserVo userVo) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.pwUpdate(userVo);
	}
	
	@Override
	public int pwAndPhotoUpdate(UserVo userVo) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.pwAndPhotoUpdate(userVo);
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
	
	@Override
	public String findPhoto(String emp_number) throws Exception {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.findPhoto(emp_number);
	}
}