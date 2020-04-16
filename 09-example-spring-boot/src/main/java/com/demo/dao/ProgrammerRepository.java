package com.demo.dao;

import com.demo.model.Programmer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProgrammerRepository extends MongoRepository<Programmer, String> {

    Programmer findByUsername(String username);
}
