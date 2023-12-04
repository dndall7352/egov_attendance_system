package egovframework.atoz.main.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import com.google.gson.Gson;

import egovframework.atoz.main.model.EmployeeDto;
import egovframework.atoz.main.model.JwtTokenDto;
import egovframework.atoz.main.model.PhotoVo;
import egovframework.atoz.main.model.SignUpDto;
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

	private static final String UPLOAD_DIR = "C:/resources/";
	
	@PostMapping("/confirm")
	public ResponseEntity<?> userConfirm(@RequestBody UserConfirmDto dto) throws Exception {
		System.out.println("사용자 확인 시작");
		UserInfoDto userinfo = userService.userConfirm(dto);

		EmployeeDto emp = new EmployeeDto(userinfo);

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> userSignUp(@ModelAttribute SignUpDto signUpDto) throws Exception {

		System.out.println("사용자 승인 요청");
		System.out.println(signUpDto.getEmp_number());
		System.out.println(signUpDto.getPassword());
		// 사용자 승인 요청 전송 sql 필요
		UserVo userVO = new UserVo();
		userVO.setEmp_number(signUpDto.getEmp_number());
		userVO.setPassword(signUpDto.getPassword());
		int cnt = 0;
		if(!signUpDto.getFile().isEmpty()) {
			String photo = userService.findPhoto(signUpDto.getEmp_number());
			File photoPath = new File(UPLOAD_DIR+photo);
			if(photo != null && photoPath.exists()) {
				Files.deleteIfExists(photoPath.toPath());
			}
			
			String filePath = signUpDto.getFile().getOriginalFilename();
			int index = filePath.lastIndexOf('.');
			String extension = filePath.substring(index);
			String uuid = UUID.randomUUID().toString();
			
			userVO.setPhoto(uuid+extension);
			System.out.println(signUpDto.getFile());
			cnt = userService.pwAndPhotoUpdate(userVO);
			File dir = new File(UPLOAD_DIR);
			
			if(!dir.exists()) {
				dir.mkdirs();
			}
			Path path = Paths.get(UPLOAD_DIR, uuid+extension);

			Files.write(path, signUpDto.getFile().getBytes());
			
		}else {
			cnt = userService.pwUpdate(userVO);
		}
		

		return new ResponseEntity<>(cnt, HttpStatus.OK);
	}

	@PostMapping("/logininfo")
	public ResponseEntity<?> loginUserInfo(@RequestBody Map<String, String> requsetBody) throws Exception {
		System.out.println("로그인 정보 요청");

		String emp_number = requsetBody.get("emp_number");
		UserInfoDto userinfo = userService.userInfo(emp_number);
		EmployeeDto emp = new EmployeeDto(userinfo);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginCheck(@RequestBody UserLoginDto userLoginDto) throws Exception {
		System.out.println("로그인 시도");
		String result;

		UserVo userVO = userService.loginCheck(userLoginDto);

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
		 EmployeeDto emp = new EmployeeDto(userInfo);

		 return ResponseEntity.ok(emp);
	}
}