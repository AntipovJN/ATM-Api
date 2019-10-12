package com.atm.test.demo.service;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.repository.AccountRepository;
import com.atm.test.demo.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> getByCardId(Long cardId) {
        return accountRepository.findById(cardId);
    }
}
