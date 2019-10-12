package com.atm.test.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class IndivisibleAmountException extends RuntimeException {

    public IndivisibleAmountException() {
    }

    public IndivisibleAmountException(String message) {
        super(message);
    }
}
