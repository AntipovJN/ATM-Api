package com.atm.test.demo.Repository;

import com.atm.test.demo.Entity.ATM;
import org.springframework.data.repository.CrudRepository;

public interface AtmRepository extends CrudRepository<ATM, Long> {
}
