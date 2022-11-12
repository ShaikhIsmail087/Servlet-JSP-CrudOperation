package com.form;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormDemoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String username=req.getParameter("uname");
        String usercontact=req.getParameter("ucontact");
        out.println("<h1>User Name:"+username+"<br>");
        out.println("<h1>User Contact:"+usercontact+"<br>");
        String[] s=req.getParameterValues("course");
        for (String s1 : s) 
        {
            out.println(s1+"<br>");
        }
        out.println("</h1>");
    }
    
}
