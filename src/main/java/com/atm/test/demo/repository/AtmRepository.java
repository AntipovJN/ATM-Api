package com.atm.test.demo.repository;

import com.atm.test.demo.entity.ATM;
import org.springframework.data.repository.CrudRepository;

public interface AtmRepository extends CrudRepository<ATM, Long> {
}
