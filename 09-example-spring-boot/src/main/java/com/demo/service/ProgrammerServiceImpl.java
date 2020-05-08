package com.demo.service;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;

import com.demo.aop.MethodDuration;
import com.demo.config.CustomProperties;
import com.demo.model.Programmer;
import com.demo.repository.ProgrammerRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	private final ProgrammerRepository programmerRepository;
	private final CustomProperties customProperties;
	private final CacheManager cacheManager;

	public ProgrammerServiceImpl(final ProgrammerRepository programmerRepository,
								 final CustomProperties customProperties,
								 final CacheManager cacheManager
	) {
		this.programmerRepository = programmerRepository;
		this.customProperties = customProperties;
		this.cacheManager = cacheManager;
	}

	@Cacheable(value = "programmers-by-username")
	@MethodDuration
	@Override
	public Programmer getByUsername(final String username) {
		return this.programmerRepository.findByUsername(username);
	}

	@Override
	public List<Programmer> getAll() {

		final Cache programmersCache = this.cacheManager.getCache("programmers");

		Programmer[] programmersArray = programmersCache.get("all", Programmer[].class);

		if (isNull(programmersArray)) {

			programmersArray = this.programmerRepository.findAll().stream()
				.limit(this.customProperties.getMaxNumberOfProgrammers())
				.toArray(Programmer[]::new);

			programmersCache.put("all", programmersArray);
		}

		return asList(programmersArray);
	}


	@Transactional
	@CachePut(value = "programmers-by-username", key = "#programmer.username")
	@Override
	public Programmer save(final Programmer programmer) {

		log.info("Saving {}", programmer);

		return programmer;
	}

	@CacheEvict(value = "programmers-by-username")
	@Override
	public void deleteByUsername(final String username) {

		this.programmerRepository.deleteByUsername(username);
	}

	@Override
	@Scheduled(fixedDelayString = "${myapp.config.jobDelay}")
	public void batchJob() {

		log.info("Batch job execution");
	}
}
