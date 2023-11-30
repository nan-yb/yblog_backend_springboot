package com.yblog.security.dao;

import com.yblog.dto.UserDetailDTO;
import com.yblog.entitiy.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDao {
    private final EntityManager em;
    public UserDao(EntityManager em) {
        this.em = em;
    }

    public Integer isIdCheck(String userEmail){
        return 0;
    }

    public UserDetailDTO getUserAccount(String userEmail){
        Member member = new Member();
        return new UserDetailDTO(member);
    }

    public void updateAccessKey(Member vo){

    }
}
