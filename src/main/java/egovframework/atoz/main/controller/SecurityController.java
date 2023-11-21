package egovframework.atoz.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.atoz.main.model.UserVo;
import egovframework.atoz.main.security.JwtTokenProvider;
import egovframework.atoz.main.service.UserService;
@RestController
public class SecurityController {

	@Autowired
	UserService userService;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	 @PostMapping("/gettoken")
	 public ResponseEntity<?> getAccessToken() throws Exception{
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		 
		 UserVo user = userService.decodeToken(userDetails.getUsername());
		 String accessToken = jwtTokenProvider.createToken(user, System.currentTimeMillis() + 1000 * 60 * 30);

		 return ResponseEntity.ok(accessToken);

	 }
}