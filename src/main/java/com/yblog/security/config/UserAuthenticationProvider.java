package com.yblog.security.config;

import com.yblog.dto.UserDetailDTO;
import com.yblog.security.service.UserDetailService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailService userDetailService;
    public UserAuthenticationProvider(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userEmail = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserDetailDTO userDetails = userDetailService.loadUserByUsername(userEmail);

        String dbPassword = userDetails.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if(!passwordEncoder.matches(password , dbPassword)){
            throw new BadCredentialsException("패스워드가 틀렸습니다.");
        }

        return new UsernamePasswordAuthenticationToken(userDetails , null ,  userDetails.getAuthorities());
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
