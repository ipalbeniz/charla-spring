package service;

import dao.ProgrammerDao;
import dao.ProgrammerDaoMap;
import model.Programmer;

public class ProgrammerServiceImpl implements ProgrammerService {

    private ProgrammerDao programmerDao = new ProgrammerDaoMap();

    public ProgrammerServiceImpl(ProgrammerDao programmerDao) {
        this.programmerDao = programmerDao;
    }

    public Programmer getById(String id) {
        return programmerDao.getById(id);
    }
}
