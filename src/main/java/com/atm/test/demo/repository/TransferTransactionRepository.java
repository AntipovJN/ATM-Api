package com.atm.test.demo.repository;

import com.atm.test.demo.entity.TransferTransaction;
import org.springframework.data.repository.CrudRepository;

public interface TransferTransactionRepository extends CrudRepository<TransferTransaction, Long> {
}
