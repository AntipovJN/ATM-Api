package com.atm.test.demo.repository;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByBankAccountsContaining(Account account);
}
