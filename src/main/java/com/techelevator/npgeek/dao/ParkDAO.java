package com.techelevator.npgeek.dao;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;

public interface ParkDAO {
	
	public List<Park> getAllParks();
	
	public Park getParkInfo(String parkCode);

}
