package egovframework.atoz.mobile.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.mobile.model.UserVo;
import egovframework.atoz.mobile.security.JwtTokenProvider;
import egovframework.atoz.mobile.service.UserService;
@RestController
public class SecurityController {

	@Autowired
	UserService userService;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	 @PostMapping("/gettoken.do")
	 public ResponseEntity<?> getAccessToken() throws Exception{
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 
		 UserVo user = userService.decodeToken(userDetails.getUsername());
		 String accessToken = jwtTokenProvider.createToken(user, System.currentTimeMillis() + 1000 * 60 * 30);

		 return ResponseEntity.ok(accessToken);

	 }
}