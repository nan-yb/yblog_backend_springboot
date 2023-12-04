package com.yblog.domain.main.controller;

import com.yblog.entity.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
//    public RegisterController(IRegisterService service) {
//        this.service = service;
//    }
//
//    private final IRegisterService service;

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody Member member){

        return null;
    }
}
