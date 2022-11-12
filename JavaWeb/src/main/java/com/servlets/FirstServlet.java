package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
//import javax.servlet.annotation.*;
//@WebServlet({"/first","/fir","/sec"})
public class FirstServlet implements Servlet{
	ServletConfig conf;
	
	static 
	{
		System.out.println("servlet class loading...");
	}
	
	public FirstServlet() {
		System.out.println("servlet instatiation...");
	}

	@Override
	public void init(ServletConfig conf) throws ServletException {
		this.conf=conf;
		System.out.println("creating object:.....");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Servicing............................");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>This is my output from servlet method:</h1>");
		out.println("<h2>Today date and time is "+new Date().toString()+":</h2>");
	}

	@Override
	public void destroy() {
		System.out.println("going to destroy servlet object");
		
	}
	public ServletConfig getServletConfig() 
	{
		return this.conf;
		
	}
	public String getServletInfo() 
	{
		return "this servlet is created by Ismail Shaikh";
	}

}
//1. Right-click on project and then click on properties.
//
//2. Click on Java Build Path.
//
//3. Click on Libraries and then click on classpath.
//
//4. Click on Add Library and then select your JDK.
//
//5. Click on Apply and Close.
//
//6. Clean and build the project from Project menu on the top of the Eclipse