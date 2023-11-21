package egovframework.atoz.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import egovframework.atoz.main.model.JwtTokenDto;
import egovframework.atoz.main.model.UserConfirmDto;
import egovframework.atoz.main.model.UserInfoDto;
import egovframework.atoz.main.model.UserLoginDto;
import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.JwtTokenProvider;
import egovframework.atoz.main.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@PostMapping("/confirm")
	public ResponseEntity<?> userConfirm(@RequestBody UserConfirmDto dto) throws Exception {
		System.out.println("사용자 확인 시작");
		UserInfoDto userinfo = userService.userConfirm(dto);

		return new ResponseEntity<>(userinfo, HttpStatus.OK);
	}

	@PutMapping("/signup")
	public ResponseEntity<?> userSignUp(@RequestBody Map<String, String> requestBody) throws Exception {
		System.out.println("사용자 승인 요청");

		// 사용자 승인 요청 전송 sql 필요
		UserVo userVO = new UserVo();
		userVO.setEmp_number(requestBody.get("emp_number"));
		userVO.setPassword(requestBody.get("password"));
		userVO.setPhoto(requestBody.get("filePath"));
		int cnt = userService.pwUpdate(userVO);
		return new ResponseEntity<>(cnt, HttpStatus.OK);
	}

	@PostMapping("/logininfo")
	public ResponseEntity<?> loginUserInfo(@RequestBody Map<String, String> requsetBody) throws Exception {
		System.out.println("로그인 정보 요청");

		String emp_number = requsetBody.get("emp_number");
		UserInfoDto userinfo = userService.userInfo(emp_number);

		return new ResponseEntity<>(userinfo, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginCheck(@RequestBody UserLoginDto userLoginDto) throws Exception {
		System.out.println("로그인 시도");
		String result;

		UserVo userVO = userService.loginCheck(userLoginDto);
System.out.println(userVO);
		if (userVO == null) {
			result = "mismatch";
			return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
		} else if (userVO.getUse_pass().equals("n")) {
			result = "processing";
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		} else {
			JwtTokenDto token = jwtTokenProvider.generateToken(userVO);
			Map<String, String> responseData = new HashMap<String, String>();
			responseData.put("result", "success");
			responseData.put("accessToken", token.getAccessToken());
			responseData.put("refreshToken", token.getRefreshToken());
			return new ResponseEntity<>(responseData, HttpStatus.OK);
		}
	}
	
	@PostMapping("/user/info")
	public ResponseEntity<?> getUserInfo() throws Exception{
		System.out.println("로그인 유저 정보 불러오기");
		
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 UserInfoDto userInfo = userService.userInfo(userDetails.getUsername());

		 return ResponseEntity.ok(userInfo);
	}
}