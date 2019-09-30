package com.atm.test.demo.Repository;

import com.atm.test.demo.Entity.TransferTransaction;
import org.springframework.data.repository.CrudRepository;

public interface TransferTransactionRepository extends CrudRepository<TransferTransaction, Long> {
}
