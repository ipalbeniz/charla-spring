package controller;

import java.util.List;
import model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.ProgrammerService;

@Controller
public class ProgrammerController {

	private final ProgrammerService programmerService;

	@Autowired
	public ProgrammerController(ProgrammerService programmerService) {
		this.programmerService = programmerService;
	}

	@GetMapping(value = "/{id}")
	public Programmer getById(@PathVariable(value = "id") String id) {
		return programmerService.getById(id);
	}

	@GetMapping(value = "/")
	public List<Programmer> getAll() {
		return programmerService.getAll();
	}
}
