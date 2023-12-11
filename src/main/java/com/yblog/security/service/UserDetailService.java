package com.yblog.security.service;

import com.yblog.dto.UserDetailDTO;
import com.yblog.security.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
  private final UserDao dao;

  @Override
  public UserDetailDTO loadUserByUsername(String email) throws UsernameNotFoundException {

    if (StringUtils.isBlank(email)){
      throw new UsernameNotFoundException("not parameter email");
    }

    UserDetailDTO user = dao.getUserAccount(email);
    if(user == null) {
      throw new UsernameNotFoundException("User not authorized.");
    }
    return user;
  }
}