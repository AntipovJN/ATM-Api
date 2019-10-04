package com.atm.test.demo.service.interfaces;

import com.atm.test.demo.entity.ATM;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.Account;

import java.math.BigInteger;

public interface TransactionService {

    IOTransaction replenishBalance (ATM atm, Account user, BigInteger sum);

    IOTransaction withdrawalBalance(ATM atm, Account user, BigInteger sum);

    TransferTransaction createTransferTransaction(ATM atm, Account sender, Account recipient, BigInteger sum);
}
