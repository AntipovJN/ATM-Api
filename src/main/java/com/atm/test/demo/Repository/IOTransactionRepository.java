package com.atm.test.demo.Repository;

import com.atm.test.demo.Entity.IOTransaction;
import org.springframework.data.repository.CrudRepository;

public interface IOTransactionRepository extends CrudRepository<IOTransaction, Long> {
}
