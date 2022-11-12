package com.file;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/excel")
public class ExelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		resp.setContentType("application/vnd.ms-excel");
		out.println("<h1><table border=1>");
		out.println("<tr><th>NAME</th><th>RANK</th></tr>");
		out.println("<tr><td>SUNNY</td><td>1</td></tr>");
		out.println("<tr><td>MALLIKA</td><td>2</td></tr>");
		out.println("<tr><td>VEENA</td><td>3</td></tr>");
		out.println("<tr><td>MALIKA ARORA</td><td>4</td></tr>");
		
	}
	
}
