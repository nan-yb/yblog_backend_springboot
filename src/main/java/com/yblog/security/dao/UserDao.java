package com.yblog.security.dao;

import com.yblog.dto.UserDetailDTO;
import com.yblog.entity.Member;
import com.yblog.domain.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDao {

    private final MemberRepository memberRepository;
    private final EntityManager em;
    public UserDao(MemberRepository memberRepository, EntityManager em) {
        this.memberRepository = memberRepository;
        this.em = em;
    }

    public Integer isIdCheck(String userEmail){
        return 0;
    }

    public UserDetailDTO getUserAccount(String userEmail){
        return new UserDetailDTO(memberRepository.findByUserEmail(userEmail));
    }

    public void updateAccessKey(Member vo){

    }
}
