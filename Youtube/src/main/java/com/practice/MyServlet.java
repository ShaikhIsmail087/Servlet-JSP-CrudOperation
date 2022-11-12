package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class MyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("this is get method.....................");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h1>this is get method of my servlet </h1>");
		out.println(new Date().toString());
		
	}

}
