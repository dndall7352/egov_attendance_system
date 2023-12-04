package egovframework.atoz.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.atoz.main.dao.UserDao;
import egovframework.atoz.main.model.UserConfirmDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.model.UserLoginDto;
import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.UserDto;
import egovframework.atoz.main.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDAO;
	
	@Override
	public UserInfoDto userConfirm(UserConfirmDto dto) throws Exception {
		return userDAO.userConfirm(dto);
	}
	@Override
	public int pwUpdate(UserVo userVo) throws Exception {
		return userDAO.pwUpdate(userVo);
	}
	@Override
	public int pwAndPhotoUpdate(UserVo userVo) throws Exception {
		return userDAO.pwAndPhotoUpdate(userVo);
	}
	@Override
	public UserInfoDto userInfo(String emp_number) throws Exception {
		return userDAO.userInfo(emp_number);
	}
	
	@Override
	public UserVo loginCheck(UserLoginDto userLoginDto) throws Exception {
		return userDAO.loginCheck(userLoginDto);
	}
	@Override
	public UserDto findByEno(String emp_number) throws Exception {
		return userDAO.findByEno(emp_number);
	}
	
	@Override
	public UserVo decodeToken(String emp_number) throws Exception {
		return userDAO.decodeToken(emp_number);
	}
	@Override
	public String findPhoto(String emp_number) throws Exception {
		return userDAO.findPhoto(emp_number);
	}
}