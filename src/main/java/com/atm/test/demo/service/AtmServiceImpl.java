package com.atm.test.demo.service;

import com.atm.test.demo.exception.IndivisibleAmountException;
import com.atm.test.demo.exception.LargeAmountException;
import com.atm.test.demo.repository.AtmRepository;
import com.atm.test.demo.entity.ATM;
import com.atm.test.demo.service.interfaces.AtmService;
import com.atm.test.demo.util.SumComputingUtil;
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
        atmIO(atm, denomination100, denomination200, denomination500);
        atmRepository.save(atm);
    }

    @Override
    public void withdrawal(ATM atm, BigInteger sum)
            throws LargeAmountException, IndivisibleAmountException {
        if (sum.compareTo(SumComputingUtil.computeSum(atm.getAmountInDenominations())) < 0) {
            if (sum.mod(BigInteger.valueOf(100)).compareTo(BigInteger.valueOf(0)) == 0) {
                int denomination100;
                int denomination200;
                int denomination500;
                if (BigInteger.valueOf(atm.getAmountInDenominations().
                        getCount500denomination() * 500).compareTo(sum) <= 0) {
                    denomination500 = atm.getAmountInDenominations().getCount500denomination();
                } else {
                    denomination500 = sum.divide(BigInteger.valueOf(500)).intValue();
                    sum = sum.subtract(BigInteger.valueOf(denomination500 * 500));
                }
                if (BigInteger.valueOf(atm.getAmountInDenominations().
                        getCount200denomination() * 200).compareTo(sum) <= 0) {
                    denomination200 = atm.getAmountInDenominations().getCount200denomination();
                } else {
                    denomination200 = sum.divide(BigInteger.valueOf(200)).intValue();
                    sum = sum.subtract(BigInteger.valueOf(denomination200 * 200));
                }
                if (BigInteger.valueOf(atm.getAmountInDenominations().
                        getCount100denomination() * 100).compareTo(sum) >= 0) {
                    denomination100 = sum.divide(BigInteger.valueOf(100)).intValue();
                } else {
                    throw new IndivisibleAmountException("Indivisible amount");
                }
                atmRepository.save(
                        atmIO(atm, -denomination100, -denomination200, -denomination500));
                return;
            }
            throw new IndivisibleAmountException("Indivisible amount");
        } else {
            throw new LargeAmountException("Try lower amount");
        }
    }

    @Override
    public String info(ATM atm) {
        return atm.toString();
    }

    private ATM atmIO(ATM atm, int denomination100, int denomination200, int denomination500) {
        atm.getAmountInDenominations().setCount100denomination(
                atm.getAmountInDenominations().getCount100denomination() + denomination100);
        atm.getAmountInDenominations().setCount200denomination(
                atm.getAmountInDenominations().getCount200denomination() + denomination200);
        atm.getAmountInDenominations().setCount500denomination(
                atm.getAmountInDenominations().getCount500denomination() + denomination500);
        return atm;
    }
}
