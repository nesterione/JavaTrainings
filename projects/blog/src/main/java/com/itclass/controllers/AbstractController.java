package com.itclass.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller {
	
	public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
