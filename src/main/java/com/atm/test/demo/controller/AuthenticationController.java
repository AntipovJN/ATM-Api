package com.atm.test.demo.controller;


import com.atm.test.demo.Repository.UserRepository;
import com.atm.test.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthenticationController {

    private UserRepository userRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @RequestMapping(value = "/login")
    public String signIn(@AuthenticationPrincipal User user) {
        if(Objects.isNull(user)) {
            return "Code status 403";
        }
        return "Code status 200";
    }

}
