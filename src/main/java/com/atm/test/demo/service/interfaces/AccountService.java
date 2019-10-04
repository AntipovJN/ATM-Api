package com.atm.test.demo.service.interfaces;

import com.atm.test.demo.entity.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> getByCardId(Long cardId);
}
