package com.atm.test.demo.service;

import com.atm.test.demo.entity.Account;
import com.atm.test.demo.exception.LowBalanceException;
import com.atm.test.demo.repository.AccountRepository;
import com.atm.test.demo.repository.IOTransactionRepository;
import com.atm.test.demo.repository.TransferTransactionRepository;
import com.atm.test.demo.repository.UserRepository;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.service.interfaces.FinancialOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class FinancialOperationServiceImpl implements FinancialOperationService {

    private AccountRepository accountRepository;
    private IOTransactionRepository ioTransactionRepository;
    private TransferTransactionRepository transferTransactionRepository;

    @Autowired
    public FinancialOperationServiceImpl(
            AccountRepository accountRepository,
            IOTransactionRepository ioTransactionRepository,
            TransferTransactionRepository transferTransactionRepository) {
        this.accountRepository = accountRepository;
        this.ioTransactionRepository = ioTransactionRepository;
        this.transferTransactionRepository = transferTransactionRepository;
    }

    @Override
    public void withdrawal(IOTransaction transaction, Account user, BigInteger sum)
            throws LowBalanceException {
        if (checkBalance(user, sum)) {
            user.setBalance(user.getBalance().subtract(sum));
            accountRepository.save(user);
            ioTransactionRepository.save(transaction);
        }
    }

    @Override
    public void replenishment(IOTransaction transaction, Account user, BigInteger sum) {
        user.setBalance(user.getBalance().add(sum));
        accountRepository.save(user);
        ioTransactionRepository.save(transaction);
    }

    @Override
    public void transfer(TransferTransaction transferTransaction,
                         Account sender, Account recipient, BigInteger sum) throws LowBalanceException {
        if (checkBalance(sender, sum)) {
            sender.setBalance(sender.getBalance().subtract(sum));
            recipient.setBalance(recipient.getBalance().add(sum));
            accountRepository.save(sender);
            accountRepository.save(recipient);
            transferTransactionRepository.save(transferTransaction);
        }
    }

    private boolean checkBalance(Account user, BigInteger sum) throws LowBalanceException {
        if (user.getBalance().compareTo(sum) >= 0) {
            return true;
        } else {
            throw new LowBalanceException("Low balance");
        }
    }
}
