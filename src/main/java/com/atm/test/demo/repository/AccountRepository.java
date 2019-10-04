package com.atm.test.demo.repository;

import com.atm.test.demo.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
