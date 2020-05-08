package com.demo.repository;

import com.demo.model.Programmer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProgrammerRepository extends MongoRepository<Programmer, String> {

	Programmer findByUsername(String username);

	void deleteByUsername(String username);
}
