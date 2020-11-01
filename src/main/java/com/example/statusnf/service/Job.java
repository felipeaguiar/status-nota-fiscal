package com.example.statusnf.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.statusnf.domain.Status;
import com.example.statusnf.domain.StatusCrawler;
import com.example.statusnf.repository.StatusRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@EnableScheduling
public class Job {
	
	@Autowired
	private StatusCrawler crawler;
	
	@Autowired
	private StatusRepository statusRepository;
	
    @Scheduled(fixedRate = 1000 * 60 * 5)
    public void aCadaCincoMinutos() {
    	Optional<Status> status = crawler.carregarDados();
    	
    	if (status.isPresent()) {
    		statusRepository.save(status.get());
    	} else {    		
    		log.error("Não foi possível gravar o status.");
    	}
    	
    }

}
