package com.poc.dao;

import java.util.List;

import com.poc.pojo.Details;

public interface DetailsDao {
	public void insertDetails(Details details);

	public List<Details> retrieveDetails();

	public void updateDetails(Details details);

	public void deletedDetails(int id);
}
