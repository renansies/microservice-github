package com.ibm.br.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUser {

	private String password;
	
	private String username;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public GithubUser(String password, String username) {
		this.password = password;
		this.username = username;
	}
	
	public GithubUser() {
		
	}
	
	@Override
	public String toString() {
		return "GithubUser [password=" + password + ", username=" + username + "]";
	}
	
}
