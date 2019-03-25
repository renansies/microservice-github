package com.ibm.br.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositorySummary {

	@JsonProperty("private")
	private Boolean _private;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	private String description;
	
	@JsonProperty("full_name")
	private String fullName;
	
	private String language;
	
	private String name;
	
	private Owner owner;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	public Boolean get_private() {
		return _private;
	}
	public void set_private(Boolean _private) {
		this._private = _private;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "RepositorySummary [_private=" + _private + ", createdAt=" + createdAt + ", description=" + description
				+ ", fullName=" + fullName + ", language=" + language + ", name=" + name 
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
