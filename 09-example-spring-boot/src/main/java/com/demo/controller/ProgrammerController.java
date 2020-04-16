package com.demo.controller;

import com.demo.model.Programmer;
import com.demo.service.ProgrammerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProgrammerController {

    private ProgrammerService programmerService;

    public ProgrammerController(ProgrammerService programmerService) {
        this.programmerService = programmerService;
    }

    @GetMapping(value = "/{username}")
    public Programmer getByUsername(@PathVariable(value="username") String username) {
        return programmerService.getByUsername(username);
    }

    @RequestMapping(value = "/")
    public List<Programmer> getAll() {
        return programmerService.getAll();
    }
}
