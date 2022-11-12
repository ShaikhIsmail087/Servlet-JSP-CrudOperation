package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.*;

@SuppressWarnings("serial")
public class List extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","ismail@123");
			PreparedStatement stmt = connection.prepareStatement("select * from employee_details");
			ResultSet rs = stmt.executeQuery();
			PrintWriter out = res.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr>");
				out.println("<th style='width:50px'>");
					out.println("ID");
				out.println("</th>");
				out.println("<th style='width:150px'>");
					out.println("Name");
				out.println("</th>");
				out.println("<th style='width:100px'>");
					out.println("Salary");
				out.println("</th>");
			out.println("</tr>");
			while(rs.next()) {
				out.println("<tr>");
					out.println("<th>");
						out.println(rs.getInt(1));
					out.println("</th>");
					out.println("<th>");
						out.println(rs.getString(2));
					out.println("</th>");
					out.println("<th>");
						out.println(rs.getInt(3));
					out.println("</th>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<h2> <a href='index.html'>Index</a> || <a href='insert.html'>Insert</a> </h2>");
			out.println("</body>");
			out.println("</html>");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
