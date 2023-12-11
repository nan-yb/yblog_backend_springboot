package com.yblog.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    Logger log = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable()
//                .formLogin().disable()
//                .headers().disable()
//                .rememberMe().disable();

        http.csrf().disable();

        http.authorizeRequests()
//                .antMatchers("/**/o2o/introduce").permitAll()
//                .antMatchers("/**/o2o/techAdv**").hasRole(RoleCd.SPECIAL.securityName)
//                .antMatchers("/**").authenticated();
//                .antMatchers("/**/mypage/**").authenticated()
                .anyRequest().permitAll();

        http.formLogin()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(new CustomAuthSuccessHandler()) // 로그인 실패 핸들러
                .failureHandler(new CustomAuthFailureHandler()) // 로그인 실패 핸들러
                .permitAll();

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        return http.build();
    }


}
