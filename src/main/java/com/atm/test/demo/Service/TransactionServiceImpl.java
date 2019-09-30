package com.atm.test.demo.Service;

import com.atm.test.demo.Entity.ATM;
import com.atm.test.demo.Entity.IOTransaction;
import com.atm.test.demo.Entity.TransferTransaction;
import com.atm.test.demo.Entity.User;
import com.atm.test.demo.Service.Interface.TransactionService;
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
    public TransferTransaction createTransferTransaction(ATM atm, User sender, User recipient, BigInteger sum) {
        return new TransferTransaction(atm,sender,recipient,sum);
    }
}
