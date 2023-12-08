package com.yblog.domain.service.impl;


import com.yblog.domain.service.IRegisterService;
import com.yblog.dto.RoleCD;
import com.yblog.entity.Member;
import com.yblog.domain.repository.MemberRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class RegisterServiceImpl implements IRegisterService {

    private final MemberRepository repository;

    public RegisterServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member createMember(Member member) {

        // ID 검증


        // encode
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));

        // 권한 부여
        member.setRoleCd(RoleCD.NORMAL);

        return repository.save(member);
    }
}
