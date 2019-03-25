package com.ibm.br.service;

import java.util.List;

import com.ibm.br.domain.GithubUser;
import com.ibm.br.domain.RepositorySummary;

public interface GithubService {

	List<RepositorySummary> findRepositoriesByUser(GithubUser user);
}
