package com.atm.test.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class LargeAmountException extends RuntimeException{

    public LargeAmountException() {
    }

    public LargeAmountException(String message) {
        super(message);
    }
}
