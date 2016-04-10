package com.itclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itclass.models.User;
import com.itclass.services.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService service;
	
	@RequestMapping("registration")
	public String registrationView() {
		return "signup";
	}
	
	@RequestMapping(value="registration", method=RequestMethod.POST)
	public String registration(User user) {
		service.registration(user);
		return "redirect:/article/all";
	}
		
	
}
