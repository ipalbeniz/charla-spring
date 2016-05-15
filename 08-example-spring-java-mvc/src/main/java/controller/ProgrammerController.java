package controller;

import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.ProgrammerService;

import java.util.List;

@RestController
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Programmer getById(@PathVariable(value="id") String id) {
        return programmerService.getById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Programmer> getAll() {
        return programmerService.getAll();
    }
}
