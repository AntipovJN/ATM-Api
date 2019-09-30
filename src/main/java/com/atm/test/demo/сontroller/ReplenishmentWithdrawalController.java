package com.atm.test.demo.сontroller;

import com.atm.test.demo.exception.AtmNotFoundException;
import com.atm.test.demo.exception.UserNotFoundException;
import com.atm.test.demo.entity.ATM;
import com.atm.test.demo.entity.IOTransaction;
import com.atm.test.demo.entity.TransferTransaction;
import com.atm.test.demo.entity.User;
import com.atm.test.demo.service.interfaces.AtmService;
import com.atm.test.demo.service.interfaces.FinancialOperationService;
import com.atm.test.demo.service.interfaces.TransactionService;
import com.atm.test.demo.service.interfaces.UserService;
import com.atm.test.demo.util.SumComputingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/api/atm/")
public class ReplenishmentWithdrawalController {

    private TransactionService transactionService;
    private FinancialOperationService financialOperationService;
    private AtmService atmService;
    private UserService userService;

    @Autowired
    public ReplenishmentWithdrawalController(TransactionService ioTransactionService,
                                             FinancialOperationService financialOperationService,
                                             AtmService atmService,
                                             UserService userService) {
        this.transactionService = ioTransactionService;
        this.financialOperationService = financialOperationService;
        this.atmService = atmService;
        this.userService = userService;
    }

    @RequestMapping(value = "{id}/replenish", method = RequestMethod.POST)
    public IOTransaction replenishTransaction(@PathVariable String id,
                                              @AuthenticationPrincipal User user,
                                              int denom100, int denom200, int denom500) {
        Optional<ATM> optionalATM = atmService.getById(Long.valueOf(id));
        if (optionalATM.isPresent()) {
            ATM atm = optionalATM.get();
            atmService.replenish(atm, denom100, denom200, denom500);
            BigInteger sum = SumComputingUtil.computeSum(denom100, denom200, denom500);
            IOTransaction transaction = transactionService.replenishBalance(atm, user, sum);
            financialOperationService.replenishment(transaction, user, sum);
            return transaction;
        }
        throw new AtmNotFoundException("ATM not found");
    }

    @RequestMapping(value = "{id}/withdrawal", method = RequestMethod.POST)
    public IOTransaction withdrawalTransaction(@AuthenticationPrincipal User user,
                                               @PathVariable String id, int sum) {
        Optional<ATM> optionalATM = atmService.getById(Long.valueOf(id));
        if (optionalATM.isPresent()) {
            ATM atm = optionalATM.get();
            BigInteger bigIntegerSum = BigInteger.valueOf(sum);
            atmService.withdrawal(atm, bigIntegerSum);
            IOTransaction transaction = transactionService.withdrawalBalance(atm, user, bigIntegerSum);
            financialOperationService.withdrawal(transaction, user, bigIntegerSum);
            return transaction;
        }
        throw new AtmNotFoundException("ATM not found");
    }

    @RequestMapping(value = "{id}/transfer", method = RequestMethod.POST)
    public TransferTransaction transferTransaction(@AuthenticationPrincipal User user,
                                                   @PathVariable String id,
                                                   String recipientCardId, int sum) {
        Optional<ATM> optionalATM = atmService.getById(Long.valueOf(id));
        if (optionalATM.isPresent()) {
            Optional<User> optionalUser = userService.getUserByCardId(Long.valueOf(recipientCardId));
            if (optionalUser.isPresent()) {
                ATM atm = optionalATM.get();
                User recipient = optionalUser.get();
                BigInteger bigIntegerSum = BigInteger.valueOf(sum);
                TransferTransaction transaction = transactionService.createTransferTransaction(
                        atm, user, recipient, bigIntegerSum);
                financialOperationService.transfer(transaction, user, recipient, bigIntegerSum);
                return transaction;
            }
            throw new UserNotFoundException(
                    String.format("User with card id ='%s' not found", recipientCardId));
        }
        throw new AtmNotFoundException("ATM not found");
    }

}
