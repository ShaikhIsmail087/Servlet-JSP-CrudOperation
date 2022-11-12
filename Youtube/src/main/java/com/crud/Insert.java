package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.*;

@SuppressWarnings("serial")
public class Insert extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Connection con;
		PrintWriter out=res.getWriter();
		try 
		{
		if(req.getParameter("id")!="" && req.getParameter("name")!="" && req.getParameter("salary")!="") {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","ismail@123");
			PreparedStatement pst=con.prepareStatement("insert into employee_details(id,name,salary)values(?,?,?)");
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("name");
			int salary=Integer.parseInt(req.getParameter("salary"));
			pst.setInt(1,id);
			pst.setString(2, name);
			pst.setInt(3, salary);
			int result = pst.executeUpdate();

			out.println("<html>");
			out.println("<body>");
			out.println("<h2>"+result+" record inserted</h2>");
			out.println("<h2> <a href='index.html'>Index</a> || <a href='list'>List</a> </h2>");
			out.println("</body>");
			out.println("</html>");
			con.close();
			}
			else 
			{
				out.println("Invalid!!");	
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
