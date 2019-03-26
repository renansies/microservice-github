package com.ibm.br.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.br.domain.GithubUser;
import com.ibm.br.domain.RepositorySummary;
import com.ibm.br.service.GithubService;

@RestController
@RequestMapping("/")
public class GithubController {
	
	private static final Logger log = LoggerFactory.getLogger(GithubController.class);
	
	@Autowired
	private GithubService service;
	
	@PostMapping("/list")
	public ResponseEntity<Page<RepositorySummary>> indexUsingPOST(@RequestBody GithubUser user, Pageable page) {
		
		log.info("Request controller to get repositories by github user");
		
		Page<RepositorySummary> repos = service.findRepositoriesByUser(page, user);
		
		return new ResponseEntity<Page<RepositorySummary>>(repos, HttpStatus.OK);
	}
}

