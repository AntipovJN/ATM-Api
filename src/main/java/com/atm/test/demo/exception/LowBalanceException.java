package com.atm.test.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class LowBalanceException extends RuntimeException {

    public LowBalanceException(String message) {
        super(message);
    }

    public LowBalanceException() {
    }
}
