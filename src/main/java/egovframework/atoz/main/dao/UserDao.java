package egovframework.atoz.main.dao;

import egovframework.atoz.main.model.UserConfirmDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.model.UserLoginDto;
import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.UserDto;

public interface UserDao {
	UserInfoDto userConfirm(UserConfirmDto dto) throws Exception;
	int pwUpdate(UserVo userVo) throws Exception;
	int pwAndPhotoUpdate(UserVo userVo) throws Exception;
	UserInfoDto userInfo(String emp_number) throws Exception;
	UserVo loginCheck(UserLoginDto userLoginDto) throws Exception;
	UserDto findByEno(String emp_number) throws Exception;
	UserVo decodeToken(String emp_number) throws Exception;
	String findPhoto(String emp_number) throws Exception;
}
