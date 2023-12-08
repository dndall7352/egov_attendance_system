package egovframework.atoz.mobile.service;

import egovframework.atoz.mobile.model.UserConfirmDto;
import egovframework.atoz.mobile.model.UserInfoDto;
import egovframework.atoz.mobile.model.UserLoginDto;
import egovframework.atoz.mobile.model.UserVo;
import egovframework.atoz.mobile.security.UserDto;

public interface UserService {
	UserInfoDto userConfirm(UserConfirmDto dto) throws Exception;
	int pwUpdate(UserVo userVo) throws Exception;
	int pwAndPhotoUpdate(UserVo userVo) throws Exception;
	UserInfoDto userInfo(String emp_number) throws Exception;
	UserVo loginCheck(UserLoginDto userLoginDto) throws Exception;
	UserDto findByEno(String emp_number) throws Exception;
	UserVo decodeToken(String emp_number) throws Exception;
	String findPhoto(String emp_number) throws Exception;
}
