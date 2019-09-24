package com.atm.test.demo.Repository;

import com.atm.test.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
