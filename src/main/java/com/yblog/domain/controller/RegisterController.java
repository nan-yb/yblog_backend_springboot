package com.yblog.domain.controller;

import com.yblog.domain.service.IRegisterService;
import com.yblog.entity.Member;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final IRegisterService service;

    public RegisterController(IRegisterService service) {
        this.service = service;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public Member register(@RequestBody Member member){
        return service.createMember(member);
    }
}
