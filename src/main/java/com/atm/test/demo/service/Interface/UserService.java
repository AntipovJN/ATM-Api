package com.atm.test.demo.service.Interface;

import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.User;

import java.math.BigInteger;
import java.util.Optional;

public interface UserService {

    BigInteger getBalance(User user);

    Optional<User> getUserByCardId(Long id);

}
