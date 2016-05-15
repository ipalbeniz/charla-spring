package dao;

import model.Programmer;

/**
 * Programmer DAO Interface
 */
public interface ProgrammerDao {

    Programmer getById(String id);
}
