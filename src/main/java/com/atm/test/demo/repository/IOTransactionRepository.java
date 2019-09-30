package com.atm.test.demo.repository;

import com.atm.test.demo.entity.IOTransaction;
import org.springframework.data.repository.CrudRepository;

public interface IOTransactionRepository extends CrudRepository<IOTransaction, Long> {
}
