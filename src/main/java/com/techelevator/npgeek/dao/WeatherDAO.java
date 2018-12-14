package com.techelevator.npgeek.dao;

import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

public interface WeatherDAO {
	
	public List<Weather> getFiveDayForecast(String parkCode);

}
