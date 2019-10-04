package com.atm.test.demo.service;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.repository.UserRepository;
import com.atm.test.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByAccount(Account account) {
        return userRepository.findByBankAccountsContaining(account);
    }
}
