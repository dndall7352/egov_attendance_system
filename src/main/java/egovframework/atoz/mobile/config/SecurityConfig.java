package egovframework.atoz.mobile.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import egovframework.atoz.mobile.security.JwtAuthenticationFilter;
import egovframework.atoz.mobile.security.JwtTokenProvider;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Slf4j
@Configuration // 해당 클래스를 Spring Configuration으로 등록
@EnableWebSecurity // Spring Security를 활성화
@EnableGlobalMethodSecurity(prePostEnabled = true) // 메소드 수준에서의 보안을 활성화
public class SecurityConfig{
	
	private JwtTokenProvider jwtTokenProvider;
	
	public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

    @Bean// HttpSecurity를 사용하여 Web Security 설정을 오버라이드한다.
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        		.authorizeRequests()
        		.antMatchers(
        				"/login",
        				"/signup",
        				"/confirm",
        				"/logininfo",
        				"/company"
        				).permitAll()
//        		.antMatchers("/signup").permitAll()
//        		.antMatchers("/confirm").permitAll()
//        		.antMatchers("/logininfo").permitAll()
                .antMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .cors().disable()
                .csrf().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                
        
        http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    
//    @Bean
//    public HttpFirewall customHttpFirewall() {
//        StrictHttpFirewall firewall = new StrictHttpFirewall();
//        firewall.setAllowUrlEncodedDoubleSlash(true);
//        return firewall;
//    }
    
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//    	CorsConfiguration configuration = new CorsConfiguration();
//    	configuration.addAllowedOrigin("*"); // 모든 도메인 허용 (실제 운영에서는 필요한 도메인만 설정해야 함)
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return source;
//    }


}