package com.atm.test.demo.service.Interface;

import com.atm.test.demo.entity.User;

import java.math.BigInteger;

public interface UserService {

    BigInteger getBalance(User user);

    void withdrawal(User user, BigInteger sum);

    void replenishment(User user, BigInteger sum);

    void transfer(User sender, User recipient, BigInteger sum);

}
