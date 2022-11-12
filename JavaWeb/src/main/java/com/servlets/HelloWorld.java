package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("This is servlet using GenericServlet");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>Hello Servlet World</h1>");
		out.println("<h2>Today date and time is "+new Date().toString()+":</h2>");
	}

}
