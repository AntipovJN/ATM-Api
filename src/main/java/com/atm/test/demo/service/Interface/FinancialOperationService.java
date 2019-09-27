package com.atm.test.demo.service.Interface;

import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.User;

import java.math.BigInteger;

public interface FinancialOperationService {

    void withdrawal(IOTransaction transaction, User user, BigInteger sum);

    void replenishment(IOTransaction transaction, User user, BigInteger sum);

    void transfer(TransferTransaction transferTransaction, User sender, User recipient, BigInteger sum);
}
