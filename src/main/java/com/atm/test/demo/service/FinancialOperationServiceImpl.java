package com.atm.test.demo.service;

import com.atm.test.demo.Exception.LowBalanceException;
import com.atm.test.demo.Repository.IOTransactionRepository;
import com.atm.test.demo.Repository.TransferTransactionRepository;
import com.atm.test.demo.Repository.UserRepository;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.service.Interface.FinancialOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class FinancialOperationServiceImpl implements FinancialOperationService {


    private UserRepository userRepository;
    private IOTransactionRepository ioTransactionRepository;
    private TransferTransactionRepository transferTransactionRepository;

    @Autowired
    public FinancialOperationServiceImpl(UserRepository userRepository,
                                         IOTransactionRepository ioTransactionRepository,
                                         TransferTransactionRepository transferTransactionRepository) {
        this.userRepository = userRepository;
        this.ioTransactionRepository = ioTransactionRepository;
        this.transferTransactionRepository = transferTransactionRepository;
    }

    @Override
    public void withdrawal(IOTransaction transaction, User user, BigInteger sum) throws LowBalanceException {
        if (checkBalance(user, sum)) {
            user.setBalance(user.getBalance().subtract(sum));
            userRepository.save(user);
            ioTransactionRepository.save(transaction);
        }
    }

    @Override
    public void replenishment(IOTransaction transaction, User user, BigInteger sum) {
        user.setBalance(user.getBalance().add(sum));
        userRepository.save(user);
        ioTransactionRepository.save(transaction);
    }

    @Override
    public void transfer(TransferTransaction transferTransaction,
                         User sender, User recipient, BigInteger sum) throws LowBalanceException {
        if (checkBalance(sender, sum)) {
            sender.setBalance(sender.getBalance().subtract(sum));
            recipient.setBalance(recipient.getBalance().add(sum));
            userRepository.save(sender);
            userRepository.save(recipient);
            transferTransactionRepository.save(transferTransaction);
        }
    }

    private boolean checkBalance(User user, BigInteger sum) throws LowBalanceException {
        if (user.getBalance().compareTo(sum) >= 0) {
            return true;
        } else {
            throw new LowBalanceException();
        }
    }
}
