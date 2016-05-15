package dao;

import model.Programmer;

import java.util.List;

/**
 * Programmer DAO Interface
 */
public interface ProgrammerDao {

    Programmer getById(String id);

    List<Programmer> getAll();
}
