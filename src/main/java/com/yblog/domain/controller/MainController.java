package com.yblog.domain.controller;

import com.yblog.base.ApiResponse;
import com.yblog.dto.UserDetailDTO;
import com.yblog.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@RestController
public class MainController {
    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public UserDetailDTO mainTest(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(obj instanceof UserDetailDTO){
            return (UserDetailDTO) obj;
        }

        return null;
    }
}
