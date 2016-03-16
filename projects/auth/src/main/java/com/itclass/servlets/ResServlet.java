package com.itclass.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResServlet
 */
@WebServlet("/res")
public class ResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		System.out.println( System.getProperty("user.dir"));
		System.out.println(request.getServletPath());
		
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/classes/ff.txt");
		String f = context.getRealPath("/WEB-INF/res/qw.txt");
		
		System.out.println(fullPath);
		System.out.println(f);
		
//		BufferedReader r = new BufferedReader(
//				new FileReader("classes/ff.txt"));
		
		
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append(r.readLine());
	}

}
