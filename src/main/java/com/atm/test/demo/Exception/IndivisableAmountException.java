package com.atm.test.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class IndivisableAmountException extends RuntimeException {

    public IndivisableAmountException() {
    }

    public IndivisableAmountException(String message) {
        super(message);
    }
}
