package com.atm.test.demo.service;

import com.atm.test.demo.Exception.LowBalanceException;
import com.atm.test.demo.Repository.UserRepository;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
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
    public void withdrawal(User user, BigInteger sum) {
        user.setBalance(user.getBalance().add(sum));
        userRepository.save(user);
    }

    @Override
    public void replenishment(User user, BigInteger sum) throws LowBalanceException {
        if (user.getBalance().compareTo(sum) >= 0) {
            user.setBalance(user.getBalance().subtract(sum));
            userRepository.save(user);
        } else {
            throw new LowBalanceException();
        }
    }

    @Override
    public void transfer(User sender, User recipient, BigInteger sum) throws LowBalanceException{
        replenishment(sender, sum);
        withdrawal(sender, sum);
    }
}
