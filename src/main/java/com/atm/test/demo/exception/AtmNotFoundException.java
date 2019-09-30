package com.atm.test.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AtmNotFoundException extends RuntimeException {

    public AtmNotFoundException() {
    }

    public AtmNotFoundException(String message) {
        super(message);
    }
}
