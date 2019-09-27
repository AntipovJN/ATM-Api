package com.atm.test.demo.service;

import com.atm.test.demo.Exception.IndivisableAmountException;
import com.atm.test.demo.Exception.LargeAmountException;
import com.atm.test.demo.Repository.AtmRepository;
import com.atm.test.demo.entity.ATM;
import com.atm.test.demo.entity.AmountInDenominations;
import com.atm.test.demo.service.Interface.AtmService;
import com.atm.test.demo.utils.SumComputingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Optional;

@Service
@Transactional
public class AtmServiceImpl implements AtmService {

    private AtmRepository atmRepository;

    @Autowired
    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public Optional<ATM> getById(Long id) {
        return atmRepository.findById(id);
    }

    @Override
    public void replenish(ATM atm, int denomination100, int denomination200, int denomination500) {
        atm.setCount100denomination(atm.getCount100denomination() + denomination100);
        atm.setCount200denomination(atm.getCount200denomination() + denomination200);
        atm.setCount500denomination(atm.getCount500denomination() + denomination500);
        atmRepository.save(atm);
    }

    @Override
    public void withdrawal(ATM atm, BigInteger sum) throws LargeAmountException, IndivisableAmountException {
        if (sum.compareTo(SumComputingUtil.computeSum(atm.getCount100denomination(),
                atm.getCount200denomination(), atm.getCount500denomination())) < 0) {
            AmountInDenominations amountInDenominations = new AmountInDenominations(0, 0, 0);
            for (int i = 0; i < atm.getCount500denomination(); i++) {
                if (sum.compareTo(SumComputingUtil.computeSum(
                        amountInDenominations).add(BigInteger.valueOf(500))) > 0) {
                    amountInDenominations.setCount500denomination(
                            amountInDenominations.getCount500denomination() + 1);
                } else {
                    break;
                }
            }
            for (int i = 0; i < atm.getCount200denomination(); i++) {
                if (sum.compareTo(SumComputingUtil.computeSum(
                        amountInDenominations).add(BigInteger.valueOf(200))) > 0) {
                    amountInDenominations.setCount200denomination(
                            amountInDenominations.getCount200denomination() + 1);
                } else {
                    break;
                }
            }
            for (int i = 0; i < atm.getCount100denomination(); i++) {
                if (sum.compareTo(SumComputingUtil.computeSum(
                        amountInDenominations).add(BigInteger.valueOf(100))) >= 0) {
                    amountInDenominations.setCount100denomination(
                            amountInDenominations.getCount100denomination() + 1);
                } else if (SumComputingUtil.computeSum(amountInDenominations).compareTo(sum) == 0) {
                    break;
                } else {
                    throw new IndivisableAmountException("Indivisible amount");
                }
            }
            System.out.println(amountInDenominations.toString());
            atm.setCount100denomination(atm.getCount100denomination() - amountInDenominations.getCount100denomination());
            atm.setCount200denomination(atm.getCount200denomination() - amountInDenominations.getCount200denomination());
            atm.setCount500denomination(atm.getCount500denomination() - amountInDenominations.getCount500denomination());
            atmRepository.save(atm);

        } else {
            throw new LargeAmountException("Try lower amount");
        }
    }

    @Override
    public String info(ATM atm) {
        return atm.toString();
    }
}
