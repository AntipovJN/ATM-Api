package com.atm.test.demo.service.interfaces;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;

import java.math.BigInteger;

public interface FinancialOperationService {

    void withdrawal(IOTransaction transaction, Account user, BigInteger sum);

    void replenishment(IOTransaction transaction, Account user, BigInteger sum);

    void transfer(TransferTransaction transferTransaction, Account sender, Account recipient, BigInteger sum);
}
