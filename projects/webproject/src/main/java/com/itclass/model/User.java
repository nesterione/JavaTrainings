package com.itclass.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Users")
public class User {
	
	private int id;
	private String name;
	private String password;
	
	public User() {
	}
	
	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	 @Id
	 @GeneratedValue(generator="increment")
	 @GenericGenerator(name="increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="userName", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	
	
}
