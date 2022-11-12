package com.poc.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poc.dao.DetailsDao;
import com.poc.pojo.Details;
import com.poc.utility.JDBCConnectionUtility;

public class DetailsDaoimpl implements DetailsDao {
	@Override
	public void insertDetails(Details details) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			String query = "insert into student(student_name, roll_number, surname) value(?,?,?)";
			connection = JDBCConnectionUtility.getConnection();
			stmt = connection.prepareStatement(query);
			stmt.setString(1, details.getStudent_name());
			stmt.setString(2, details.getRoll_number());
			stmt.setString(3, details.getSurname());
			int i = stmt.executeUpdate();
			if (i == 1) {
				System.out.println("1 row inserted" + details.toString());
			} else {
				System.out.println("1 row not inserted");
			}
			connection.close();
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Details> retrieveDetails() {
		List<Details> list = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = JDBCConnectionUtility.getConnection();
			String query = "select * from student";
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Details details = new Details();
				details.setId(rs.getInt("id"));
				details.setStudent_name(rs.getString("student_name"));
				details.setRoll_number(rs.getString("roll_number"));
				details.setSurname(rs.getString("surname"));
				list.add(details);
			}
			connection.close();
			stmt.close();

		} catch (Exception e) {

		}
		return list;

	}

	@Override
	public void updateDetails(Details details) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = JDBCConnectionUtility.getConnection();
			String quary = "update student set student_name=?, roll_number=?, surname=? where id=?";
			stmt = connection.prepareStatement(quary);
			stmt.setString(1, details.getStudent_name());
			stmt.setString(2, details.getRoll_number());
			stmt.setString(3, details.getSurname());
			stmt.setInt(4, details.getId());
			stmt.executeUpdate();
			stmt.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletedDetails(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {

			connection = JDBCConnectionUtility.getConnection();
			String query = "delete from student where id=?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("i row deleted");
			} else {
				System.out.println("1 row not deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
