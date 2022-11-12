package com.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class ClientServerInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("<html><body><h1>Client Server Information</h1>");
		out.println("<h2>Client IP address:"+req.getRemoteAddr()+"</h1>");
		out.println("<h2>Client Host:"+req.getRemoteHost()+"</h2>");
		out.println("<h2>Client Port:"+req.getRemotePort()+"</h2>");
		out.println("<h2>Server Name:"+req.getServerName()+"</h2>");
		out.println("<h2>Server Port:"+req.getServerPort()+"</h2>");
		out.println("</table></body></html>");
	}

}
