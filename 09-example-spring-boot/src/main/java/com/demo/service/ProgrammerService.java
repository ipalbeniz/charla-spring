package com.demo.service;

import com.demo.model.Programmer;

import java.util.List;

public interface ProgrammerService {

	Programmer getByUsername(String id);

	List<Programmer> getAll();

	Programmer save(Programmer programmer);

	void deleteByUsername(final String username);

	void batchJob();
}
