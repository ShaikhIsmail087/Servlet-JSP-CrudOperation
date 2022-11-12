package com.poc.pojo;

public class Details {
	private int id;
	private String student_name;
	private String roll_number;
	private String surname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getRoll_number() {
		return roll_number;
	}

	public void setRoll_number(String roll_number) {
		this.roll_number = roll_number;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "Details [id=" + id + ", student_name=" + student_name + ", roll_number=" + roll_number + ", surname="
				+ surname + "]";
	}

}
