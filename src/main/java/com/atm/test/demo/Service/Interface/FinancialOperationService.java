package com.atm.test.demo.Service.Interface;

import com.atm.test.demo.Entity.IOTransaction;
import com.atm.test.demo.Entity.TransferTransaction;
import com.atm.test.demo.Entity.User;

import java.math.BigInteger;

public interface FinancialOperationService {

    void withdrawal(IOTransaction transaction, User user, BigInteger sum);

    void replenishment(IOTransaction transaction, User user, BigInteger sum);

    void transfer(TransferTransaction transferTransaction, User sender, User recipient, BigInteger sum);
}
