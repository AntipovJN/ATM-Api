package com.atm.test.demo.service.Interface;

import java.math.BigInteger;

public interface AtmService {

    void replenish(BigInteger sum);

    void withdrawal(BigInteger sim);

    String info();
}
