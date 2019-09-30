package com.atm.test.demo.Service.Interface;

import com.atm.test.demo.Entity.ATM;

import java.math.BigInteger;
import java.util.Optional;

public interface AtmService {

    Optional<ATM> getById(Long id);

    void replenish(ATM atm, int denomination100, int denomination200, int denomination500);

    void withdrawal(ATM atm, BigInteger sum);

    String info(ATM atm);
}
