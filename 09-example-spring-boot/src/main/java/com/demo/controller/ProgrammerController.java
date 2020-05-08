package com.demo.controller;

import com.demo.model.Programmer;
import com.demo.service.ProgrammerService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/programmers")
public class ProgrammerController {

	private final ProgrammerService programmerService;

	public ProgrammerController(final ProgrammerService programmerService) {
		this.programmerService = programmerService;
	}

	@GetMapping("/{username}")
	public Programmer getByUsername(@PathVariable(value = "username") final String username) {
		return this.programmerService.getByUsername(username);
	}

	@GetMapping
	public List<Programmer> getAll() {

		return this.programmerService.getAll();
	}

	@PostMapping
	public void createProgrammer(@RequestBody final Programmer programmer) {

		this.programmerService.save(programmer);
	}

	@DeleteMapping("/{username}")
	public void deleteByUsername(@PathVariable(value = "username") final String username) {
		
		this.programmerService.deleteByUsername(username);
	}
}
