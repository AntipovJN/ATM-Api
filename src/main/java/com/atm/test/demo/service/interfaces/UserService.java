package com.atm.test.demo.service.interfaces;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.entity.User;
import java.util.Optional;

public interface UserService {

    Optional<User> getByAccount(Account account);

}
