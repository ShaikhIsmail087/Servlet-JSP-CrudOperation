package com.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class RequestHeaderDemoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("<html><body><h1>Request Headers Information</h1>");
		out.println("<table border=2><tr><th>Header Name</th><th>Header Values</th></tr>");
		Enumeration<String> e=req.getHeaderNames();
		while(e.hasMoreElements())
		{
			String hname=(String)e.nextElement();
			String hvalue=req.getHeader(hname);
			out.println("<tr><td>"+hname+"</td><td>"+hvalue+"</td></tr>");
		}
		out.println("</table></body></html>");
	}

}
