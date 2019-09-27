package com.atm.test.demo.service.Interface;

import com.atm.test.demo.entity.ATM;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.User;

import java.math.BigInteger;

public interface TransactionService {

    IOTransaction replenishBalance (ATM atm, User user, BigInteger sum);

    IOTransaction withdrawalBalance(ATM atm, User user, BigInteger sum);

    TransferTransaction createTransferTransaction(ATM atm, User sender, User recipient, BigInteger sum);
}
