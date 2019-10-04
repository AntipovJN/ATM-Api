package com.atm.test.demo.service;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.repository.AccountRepository;
import com.atm.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String cardId) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findById(Long.valueOf(cardId));
           if(optionalAccount.isPresent()){
            return optionalAccount.get();
        } else {
            throw new UsernameNotFoundException("User not Found");
        }
    }
}
