package com.demo.service;

import com.demo.model.Programmer;

import java.util.List;

public interface ProgrammerService {

	Programmer getByUsername(String id);

	List<Programmer> getAll();

	void save(Programmer programmer);

	void batchJob();
}
