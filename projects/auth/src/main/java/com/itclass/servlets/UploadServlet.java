package com.itclass.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
			.getRequestDispatcher("WEB-INF/views/upload.jsp")
			.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Part part = request.getPart("file");
		String name = part.getSubmittedFileName();
		
		InputStream in = part.getInputStream();
		
		 Map<String, String> m = System.getenv();
		
		OutputStream out = new FileOutputStream(m.get("file_locations")+"/"+name);
		
		int b;
		while( (b = in.read()) !=-1 ) {
			out.write(b);
		}
		
		in.close();
		out.close();
		
		response.getWriter().println("file "+name+" saved!");
	}

}
