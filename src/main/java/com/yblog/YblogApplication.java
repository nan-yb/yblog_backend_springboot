package com.yblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class YblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(YblogApplication.class);
    }

}
