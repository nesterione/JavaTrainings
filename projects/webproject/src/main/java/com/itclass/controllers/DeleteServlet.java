package com.itclass.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itclass.services.ArticleService;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId = request.getParameter("id");
		
		try(ArticleService service = new ArticleService()) {
			
			int id = Integer.parseInt(sId);		
			service.remove(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		response.sendRedirect(request.getContextPath());
	}
}