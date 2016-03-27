package com.itclass.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("name", "qwwww");
		return modelAndView;
	}
	
	@RequestMapping(value = "/welcome", 
			method=RequestMethod.POST)
	@ResponseBody
	public User helloWorldPost(
			User user) {
		
		//System.out.println(user);
		
		return user;
	}
	
	/*
	@RequestMapping("/welcome/{name}")
	public String helloWorld(
			@PathVariable(value="name")
			String name,
			Model model) {
		
		
		model.addAttribute("name", name+1);
		return "welcome";
	}*/
	
	
	
}

// example http://javahash.com/spring-4-mvc-hello-world-tutorial-full-example/
