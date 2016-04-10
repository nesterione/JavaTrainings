package com.itclass.controller;

import javax.xml.bind.annotation.XmlRootElement;

public class User {
	private int id;
	private String user;
	private String password;
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return user;
	}

	public void setName(String name) {
		this.user = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + user + ", password=" + password + "]";
	}
	
	
	
	
}
