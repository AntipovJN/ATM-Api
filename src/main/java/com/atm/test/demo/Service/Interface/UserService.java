package com.atm.test.demo.Service.Interface;

import com.atm.test.demo.Entity.User;

import java.math.BigInteger;
import java.util.Optional;

public interface UserService {

    BigInteger getBalance(User user);

    Optional<User> getUserByCardId(Long id);

}
