package egovframework.atoz.mobile.security;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import egovframework.atoz.mobile.dao.UserDao;
import egovframework.atoz.mobile.mapper.UserMapper;
import egovframework.atoz.mobile.model.UserVo;

import java.util.Arrays;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserDao userDao;
	

	@Override
	public UserDetails loadUserByUsername(String emp_number) throws UsernameNotFoundException {
		try {
			return addAuthorities(userDao.findByEno(emp_number));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	private UserDto addAuthorities(UserDto userDTO) {
        userDTO.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDTO.getRole())));

        return userDTO;
    }
}
