package egovframework.atoz.main.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import egovframework.atoz.main.model.JwtTokenDto;
import egovframework.atoz.main.model.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import java.security.Key;
import java.util.Date;
import java.util.List;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider{ // JWT 토큰을 생성 및 검증 모듈

	private final Key key;
	@Autowired
	UserDetailsService userDetailsSercive;
	long accessTokenDate = System.currentTimeMillis() + 1000 * 60 * 30;
	long refreshTokenDate = System.currentTimeMillis() + 1000 * 60 * 60 * 30;
    public JwtTokenProvider() {
        String secretKey = "asfdslkdskjfldksfjsdlkdfjlsdkfjskjklhjkgdtydrtasdsdasdxfvgdlfj";
        byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
        this.key = Keys.hmacShaKeyFor(secretByteKey);
    }

    // JWT 토큰 생성
    public JwtTokenDto generateToken(UserVo userVo) {
        String accessToken = createToken(userVo, accessTokenDate);
        String refreshToken = createToken(userVo, refreshTokenDate);
        
        return JwtTokenDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }
    
    
    public String createToken(UserVo userVo, long tokenDate) {
    	Claims claims = Jwts.claims().setSubject(userVo.getEmp_number());
    	claims.put("roles", List.of(userVo.getAut_number()));
    	
    	return "Bearer " + Jwts.builder()
        .setClaims(claims)
        .setIssuedAt(new Date())
        .setExpiration(new Date(tokenDate))    // JWT 토큰 만료 시간
        .signWith(key,SignatureAlgorithm.HS256)  // JWT 토큰 서명
        .compact();
    }
    
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsSercive.loadUserByUsername(this.getId(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }
    
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

  
    
    public boolean validateToken(String token) {
    	try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }

    
    public String resolveToken(HttpServletRequest request) {
        // 요청 헤더에서 토큰 추출
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            // "Bearer " 접두사를 제거하고 토큰 반환
            return bearerToken.substring(7);
        }
        
        return null; // 토큰을 찾을 수 없는 경우 null 반환
    }
    
    public String getId(String token){
        return parseClaims(token).getSubject();
    }
}