package com.yblog.domain.main.service;

import com.yblog.entity.Member;
import org.springframework.stereotype.Service;

@Service
public interface IRegisterService {
    public Member createMember(Member member);

}
