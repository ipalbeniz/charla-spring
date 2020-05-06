package service;

import dao.ProgrammerDao;
import java.util.List;
import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    private final ProgrammerDao programmerDao;

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
