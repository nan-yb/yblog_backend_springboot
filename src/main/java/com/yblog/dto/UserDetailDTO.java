package com.yblog.dto;

import com.yblog.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserDetailDTO implements UserDetails {

    Logger log = LoggerFactory.getLogger(getClass());

    private final Member member;
    public UserDetailDTO(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        String role = member.getAuthCd();

        log.info("=========================================================");
        log.info("role : " + role);
        log.info("=========================================================");

//        RoleCD roleCd = RoleCD.of(role);
        String rolePrefix = "ROLE_";

//        auth.add(new SimpleGrantedAuthority(rolePrefix + Objects.requireNonNull(roleCd).securityName));
        auth.add(new SimpleGrantedAuthority(rolePrefix + "NORMAL"));
        return auth;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getName();
    }

    // 아래의 옵션들로 Spring Security가 발생시킨다.
    // false일 경우 인증을 허용하지 않고 사용자는 권한을 얻지못해 엑세스를 못함
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
