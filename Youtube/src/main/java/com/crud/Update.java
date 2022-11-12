package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;

@SuppressWarnings("serial")
public class Update extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		try {
			if(req.getParameter("id")!="") {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","ismail@123");
				PreparedStatement stmt = connection.prepareStatement("select * from employee_details where id=?");
				int id = Integer.parseInt(req.getParameter("id"));
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				boolean r = rs.next();
				if(!r) {
					out.println("<html>");
					out.println("<body>");
					out.println("<h2> No user found</h2>");
					out.println("<h2> <a href='index.html'>Index</a> || <a href='list'>List</a> </h2>");
					out.println("</body>");
					out.println("</html>");
				}
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				PreparedStatement stmt2 = connection.prepareStatement("update employee_details set name=? , salary=? where id=?");
				if(req.getParameter("name")!="" && req.getParameter("salary")!="") {
					stmt2.setString(1, req.getParameter("name"));
					stmt2.setInt(2, Integer.parseInt(req.getParameter("salary")));
					stmt2.setInt(3, id);
					stmt2.executeUpdate();
				}else if(req.getParameter("name").isEmpty() && req.getParameter("salary")!="") {
					stmt2.setString(1, name);
					stmt2.setInt(2, Integer.parseInt(req.getParameter("salary")));
					stmt2.setInt(3, id);
					stmt2.executeUpdate();
				}else if(req.getParameter("salary").isEmpty() && req.getParameter("name")!="") {
					stmt2.setString(1, req.getParameter("name"));
					stmt2.setInt(2, salary);
					stmt2.setInt(3, id);
					stmt2.executeUpdate();
				}else if(req.getParameter("name").isEmpty() && req.getParameter("salary").isEmpty()) {
					stmt2.setString(1, name);
					stmt2.setInt(2, salary);
					stmt2.setInt(3, id);
					stmt2.executeUpdate();
				}
				out.println("<html>");
				out.println("<body>");
				out.println("<h2> Record Updated</h2>");
				out.println("<h2> <a href='index.html'>Index</a> || <a href='list'>List</a> </h2>");
				out.println("</body>");
				out.println("</html>");
				connection.close();
			}else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h2> Please enter ID</h2>");
				out.println("<h2><a href='update.html'>Update</a></h2>");
				out.println("<h2> <a href='index.html'>Index</a> || <a href='insert.html'>Insert</a> </h2>");
				out.println("</body>");
				out.println("</html>");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
