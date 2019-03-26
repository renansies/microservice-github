package com.ibm.br.service;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.br.domain.GithubUser;
import com.ibm.br.domain.RepositorySummary;

@Service
public class GithubServiceImpl implements GithubService{
	
	private static final Logger log = LoggerFactory.getLogger(GithubServiceImpl.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Page<RepositorySummary> findRepositoriesByUser(Pageable page, GithubUser user) {
		log.info("Request service to get repositories by github user");
		String auth = user.getUsername() + ":" + user.getPassword();
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", authHeader);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.github.com/user/repos");
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ResponseEntity<RepositorySummary[]> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, RepositorySummary[].class); 
		return new PageImpl<>(Arrays.asList(response.getBody()), page, Arrays.asList(response.getBody()).size());
	}

}
