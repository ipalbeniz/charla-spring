package service;

import model.Programmer;

import java.util.List;

public interface ProgrammerService {

    Programmer getById(String id);

    List<Programmer> getAll();
}
