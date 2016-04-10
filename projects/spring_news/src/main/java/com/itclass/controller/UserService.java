package com.itclass.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public List<User> getUsers() {
		
		User u1 = new User();
		u1.setId(1);
		u1.setName("sdff");
		u1.setPassword("qweqw");
		
		User u2 = new User();
		u2.setId(4);
		u2.setName("retre");
		u2.setPassword("234564");
		
		return Arrays.asList(u1,u2);
	}
	
}
