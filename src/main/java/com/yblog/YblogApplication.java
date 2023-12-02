package com.yblog;


import com.yblog.repositroy.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class YblogApplication {


    @Autowired
    MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(YblogApplication.class);
    }

    @Bean
    public void initData(){

//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        Member member = new Member();
//        member.setName("test1");
//        member.setPassword(passwordEncoder.encode("test1"));
//        member.setEmail("test1");
//        member.setAuthCd("N");
//
//        memberRepository.save(member);
    }
}
