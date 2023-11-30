package com.yblog.security.config;

import com.yblog.security.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final UserDetailService service;
    private final UserAuthenticationProvider userAuthenticationProvider;

    public SecurityConfig(UserDetailService service, UserAuthenticationProvider userAuthenticationProvider) {
        this.service = service;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain memberSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
//                .antMatchers("/**/o2o/introduce").permitAll()
//                .antMatchers("/**/o2o/techAdv**").hasRole(RoleCd.SPECIAL.securityName)
                .antMatchers("/**").authenticated();
//                .antMatchers("/**/mypage/**").authenticated()
//                .anyRequest().permitAll();

        http.formLogin()
                .usernameParameter("usrEmal")
                .passwordParameter("pswd")
                .loginProcessingUrl("/login.api")
                .defaultSuccessUrl("/")
                .successHandler(new CustomAuthSuccessHandler()) // 로그인 실패 핸들러
                .failureHandler(new CustomAuthFailureHandler()) // 로그인 실패 핸들러
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout.api"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        // 중복 로그인
        // http.sessionManagement()
        // .maximumSessions(1) //세션 최대 허용 수
        // .maxSessionsPreventsLogin(false); // false이면 중복 로그인하면 이전 로그인이 풀린다.
        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider);
    }

}
