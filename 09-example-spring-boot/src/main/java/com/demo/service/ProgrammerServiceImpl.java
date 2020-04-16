package com.demo.service;

import com.demo.dao.ProgrammerRepository;
import com.demo.model.Programmer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    private ProgrammerRepository programmerRepository;

    public ProgrammerServiceImpl(ProgrammerRepository programmerRepository) {
        this.programmerRepository = programmerRepository;
    }

    public Programmer getByUsername(String username) {
        return programmerRepository.findByUsername(username);
    }

    @Override
    public List<Programmer> getAll() {
        return programmerRepository.findAll();
    }
}
