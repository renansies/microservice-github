package com.ibm.br.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ibm.br.domain.GithubUser;
import com.ibm.br.domain.RepositorySummary;

public interface GithubService {

	Page<RepositorySummary> findRepositoriesByUser(Pageable page, GithubUser user);
}
