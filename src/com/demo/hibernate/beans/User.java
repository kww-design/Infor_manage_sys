package com.demo.hibernate.beans;
// Generated 2016-4-24 22:36:56 by Hibernate Tools 3.5.0.Final

/**
 * User generated by hbm2java
 */
public class User {

	private Integer id;
	private String username;
	private String password;
	private String email;

	public User() {
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
