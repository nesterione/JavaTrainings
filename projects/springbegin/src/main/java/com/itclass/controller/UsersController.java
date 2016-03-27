package com.itclass.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("users")
public class UsersController {

	@Autowired
	private UserService service;
	
	@RequestMapping("all")
	@ResponseBody
	public List<User> add() {
		return service.getUsers();
	}
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("save/{info}")
	public void save(@PathVariable("info") 
									String info) {	
		request.getSession()
			.setAttribute("info", info);
	}
	
	@RequestMapping("show")
	@ResponseBody
	public String  show() {
	
		return (String)request.getSession()
				.getAttribute("info");
	}
	
	@RequestMapping("remove")
	public void remove() {
		request.getSession()
			.removeAttribute("info");
	}
	
}
