package com.atm.test.demo.service;

import com.atm.test.demo.entity.ATM;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.service.interfaces.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public IOTransaction replenishBalance(ATM atm, User user, BigInteger sum) {
        return new IOTransaction(atm, user, sum);
    }

    @Override
    public IOTransaction withdrawalBalance(ATM atm, User user, BigInteger sum) {
        return new IOTransaction(atm, user, sum.multiply(BigInteger.valueOf(-1)));
    }

    @Override
    public TransferTransaction createTransferTransaction(ATM atm, User sender,
                                                         User recipient, BigInteger sum) {
        return new TransferTransaction(atm,sender,recipient,sum);
    }
}
