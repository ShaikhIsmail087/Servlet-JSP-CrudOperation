package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		if(req.getParameter("n1")!="" && req.getParameter("n2")!="") 
		{
			Long l1=Long.parseLong(req.getParameter("n1"));
			Long l2=Long.parseLong(req.getParameter("n2"));
			PrintWriter out=res.getWriter();
			out.println("<h1>The sum is:"+(l1+l2)+" & The product is:"+(l1*l2)+"</h1>");
		}else 
		{
			PrintWriter out=res.getWriter();
			out.println("<h1>Sorry invalid input!!Somthing went wrong...</h1>");
		}
		
	}

}
