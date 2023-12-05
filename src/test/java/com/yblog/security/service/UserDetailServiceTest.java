package com.yblog.security.service;

import com.yblog.dto.UserDetailDTO;
import com.yblog.entity.Member;
import com.yblog.security.dao.UserDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserDetailServiceTest {

    @InjectMocks UserDetailService service;

    @Mock
    UserDao dao;

    private Member initMember(){
        Member member = new Member();
        member.setName("test2");
        member.setEmail("test2");
        member.setPassword(new BCryptPasswordEncoder().encode("test2"));
        member.setAuthCd("N");
        return member;
    }
    @Test
    @DisplayName("이메일(ID) : 로그인 기능")
    public void testLoadUserByUsername(){
        doReturn(new UserDetailDTO(initMember())).when(dao).getUserAccount(any());
//        // when
        UserDetailDTO userDetailDTO = service.loadUserByUsername("test2");
//        // then
        assertEquals(userDetailDTO.getUsername() , "test2");
//        // verify
        verify(dao, times(1)).getUserAccount(any());
    }
}