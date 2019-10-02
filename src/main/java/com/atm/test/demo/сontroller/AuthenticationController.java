package com.atm.test.demo.сontroller;


import com.atm.test.demo.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthenticationController {

    @RequestMapping(value = "/login")
    public HttpStatus signIn(@AuthenticationPrincipal User user) {
        if(Objects.isNull(user)) {
            return HttpStatus.FORBIDDEN;
        }
        return HttpStatus.OK;
    }
}
