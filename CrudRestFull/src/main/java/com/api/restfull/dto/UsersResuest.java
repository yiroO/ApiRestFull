package com.api.restfull.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsersResuest {
	
	@JsonProperty
	private String fistname;
	@JsonProperty
	private String lastname;
	@JsonProperty
	private String username;
	@JsonProperty
	private String password;
	
	public String getFistname() {
		return fistname;
	}
	public void setFistname(String fistname) {
		this.fistname = fistname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
