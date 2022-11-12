package com.poc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poc.dao.DetailsDao;
import com.poc.daoimpl.DetailsDaoimpl;
import com.poc.pojo.Details;

@WebServlet("/detailsController")
public class DetailsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DetailsDao dao = new DetailsDaoimpl();
		int id = Integer.parseInt(req.getParameter("id"));
		dao.deletedDetails(id);
		resp.sendRedirect("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("detail controller started");
		// super.doPost(req, resp);
		Details details = new Details();
		details.setStudent_name(req.getParameter("student_name"));
		details.setRoll_number(req.getParameter("roll_number"));
		details.setSurname(req.getParameter("surname"));
		System.out.println(details.toString());
		String action = req.getParameter("submit");
		DetailsDao dao = new DetailsDaoimpl();
		// dao.insertDetails(details);
		if (action.equalsIgnoreCase("save")) {
			System.out.println("save");
			dao.insertDetails(details);
		}
		else if (action.equalsIgnoreCase("update")) {
			System.out.println("id");
			details.setId(Integer.parseInt(req.getParameter("id")));
			dao.updateDetails(details);
			System.out.println(details.toString());
		}

		resp.sendRedirect("index.jsp");

	}
}
