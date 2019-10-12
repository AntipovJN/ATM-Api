package com.atm.test.demo.сontroller;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private UserService userService;

    @Autowired
    public InfoController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/atm/info")
    public User getInfo(@AuthenticationPrincipal Account account) {
        return userService.getByAccount(account).get();
    }
}
