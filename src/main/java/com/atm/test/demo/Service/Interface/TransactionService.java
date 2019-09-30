package com.atm.test.demo.Service.Interface;

import com.atm.test.demo.Entity.ATM;
import com.atm.test.demo.Entity.IOTransaction;
import com.atm.test.demo.Entity.TransferTransaction;
import com.atm.test.demo.Entity.User;

import java.math.BigInteger;

public interface TransactionService {

    IOTransaction replenishBalance (ATM atm, User user, BigInteger sum);

    IOTransaction withdrawalBalance(ATM atm, User user, BigInteger sum);

    TransferTransaction createTransferTransaction(ATM atm, User sender, User recipient, BigInteger sum);
}
