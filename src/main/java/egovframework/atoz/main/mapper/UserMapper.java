package egovframework.atoz.main.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import egovframework.atoz.main.model.UserConfirmDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.model.UserLoginDto;
import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.UserDto;

public interface UserMapper {
	UserInfoDto userConfirm(UserConfirmDto dto) throws Exception;
	int pwUpdate(UserVo userVo) throws Exception;
	int pwAndPhotoUpdate(UserVo userVo) throws Exception;
	UserInfoDto userInfo(String emp_number) throws Exception;
	UserVo loginCheck(UserLoginDto userLoginDto) throws Exception;
	UserDto findByEno(String emp_number) throws Exception;
	UserVo decodeToken(String emp_number) throws Exception;
	String findPhoto(String emp_number) throws Exception;
}
