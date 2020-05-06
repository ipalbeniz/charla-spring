package com.demo.service;

import com.demo.config.CustomProperties;
import com.demo.model.Programmer;
import com.demo.repository.ProgrammerRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	private final ProgrammerRepository programmerRepository;
	private final CustomProperties customProperties;

	public ProgrammerServiceImpl(final ProgrammerRepository programmerRepository,
								 final CustomProperties customProperties) {
		this.programmerRepository = programmerRepository;
		this.customProperties = customProperties;
	}

	@Override
	public Programmer getByUsername(final String username) {
		return this.programmerRepository.findByUsername(username);
	}

	@Cacheable(value = "programmers", key = "'allProgrammers'")
	@Override
	public List<Programmer> getAll() {

		log.debug("Entrando en getAll()");

		return this.programmerRepository.findAll().stream()
			.limit(customProperties.getMaxNumberOfProgrammers())
			.collect(Collectors.toList());
	}

	@CacheEvict(value = "programmers", key = "'allProgrammers'")
	@Override
	public void save(Programmer programmer) {

		log.debug("Saving programmer {}", programmer);
	}

	@Scheduled(fixedDelayString = "${myapp.config.jobDelay}")
	public void batchJob() {

		log.info("Batch job execution");
	}
}
