package service;

import dao.ProgrammerDao;
import dao.ProgrammerDaoMap;
import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("programmerService")
public class ProgrammerServiceImpl implements ProgrammerService {

    private ProgrammerDao programmerDao = new ProgrammerDaoMap();

    @Autowired
    public ProgrammerServiceImpl(ProgrammerDao programmerDao) {
        this.programmerDao = programmerDao;
    }

    public Programmer getById(String id) {
        return programmerDao.getById(id);
    }

    @Override
    public List<Programmer> getAll() {
        return programmerDao.getAll();
    }
}
