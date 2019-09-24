package com.atm.test.demo.service;

import com.atm.test.demo.Repository.AtmRepository;
import com.atm.test.demo.service.Interface.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Service
@Transactional
public class AtmServiceImpl implements AtmService {

    private AtmRepository atmRepository;

    @Autowired
    public AtmServiceImpl(AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
    }

    @Override
    public void replenish(BigInteger sum) {

    }

    @Override
    public void withdrawal(BigInteger sim) {

    }

    @Override
    public String info() {
        return null;
    }
}
