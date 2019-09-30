package com.atm.test.demo.Service;

import com.atm.test.demo.Repository.UserRepository;
import com.atm.test.demo.Entity.User;
import com.atm.test.demo.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BigInteger getBalance(User user) {
        return user.getBalance();
    }

    @Override
    public Optional<User> getUserByCardId(Long id) {
        return userRepository.findById(id);
    }
}
