package egovframework.atoz.main.service;

import egovframework.atoz.main.model.UserConfirmDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.model.UserLoginDto;
import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.UserDto;

public interface UserService {
	UserInfoDto userConfirm(UserConfirmDto dto) throws Exception;
	int pwUpdate(UserVo userVO) throws Exception;
	UserInfoDto userInfo(String emp_number) throws Exception;
	UserVo loginCheck(UserLoginDto userLoginDto) throws Exception;
	UserDto findByEno(String emp_number) throws Exception;
	UserVo decodeToken(String emp_number) throws Exception;
}
