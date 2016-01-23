package com.itclass.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("main");
		
		//String user = (String) request.getSession().getAttribute("user");
		//request.setAttribute("user", user);
		
		request
			.getRequestDispatcher("WEB-INF/index.jsp")
			.forward(request, response);
	}

}
