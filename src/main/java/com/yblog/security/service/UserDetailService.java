package com.yblog.security.service;

import com.yblog.dto.UserDetailDTO;
import com.yblog.security.dao.UserDao;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailService implements UserDetailsService {

  private final UserDao dao;
  public UserDetailService(UserDao dao){
    this.dao = dao;
  }

  @Override
  public UserDetailDTO loadUserByUsername(String userEmail) throws UsernameNotFoundException {
    UserDetailDTO user = dao.getUserAccount(userEmail);
    if (user == null) {
      throw new UsernameNotFoundException("User not authorized.");
    }
    return user;
  }
}