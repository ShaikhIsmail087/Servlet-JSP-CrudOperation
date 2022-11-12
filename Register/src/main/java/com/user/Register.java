package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            
            //getting all the incoming detail from the request...
            
            String name=request.getParameter("user_name");
            String password=request.getParameter("user_password");
            String email=request.getParameter("user_email");
            out.println(name);
            out.println(password);
            out.println(email);
            
            //connection.................
            
            try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","ismail@123");
				//query
				String q="insert into client(ename,epassword,email) values(?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(q);
				pstmt.setString(1, name);
				pstmt.setString(2, password);
				pstmt.setString(3, email);
				
				pstmt.executeUpdate();
				
				out.println("done....");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				out.println("error....");
			}
            
        }
	}
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
