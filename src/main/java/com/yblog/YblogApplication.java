package com.yblog;


import com.yblog.domain.common.repository.MemberRepository;
import com.yblog.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableRedisRepositories
public class YblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(YblogApplication.class);
    }

}
