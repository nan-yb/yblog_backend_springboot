package com.yblog.domain.main.service;

import com.yblog.entitiy.Member;
import com.yblog.repositroy.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class RegisterServiceImplTest {

    @InjectMocks
    private RegisterServiceImpl service;

    @Mock
    private MemberRepository repository;

    private Member initMember(){
        Member member = new Member();
        member.setName("test2");
        member.setEmail("test2");
        member.setPassword(new BCryptPasswordEncoder().encode("test2"));
        member.setAuthCd("N");
        return member;
    }

    @Test
    void createMember() {

        // when
        Member member = initMember();
        lenient().when(service.createMember(any())).thenReturn(member);

        // then
        assertEquals(member.getName() , "test2");
    }


}