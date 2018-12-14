package com.techelevator.npgeek.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.techelevator.npgeek.dao.WeatherDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

@Repository
public class JdbcWeatherDAO implements WeatherDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Weather> getFiveDayForecast(String parkCode) {
		List<Weather> fiveDayForecast = new ArrayList<>();
		String parkCodeAllCaps = parkCode.toUpperCase();
		String sqlSelectForecast = "SELECT * FROM weather WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectForecast, parkCodeAllCaps);
		while (results.next()) {
			Weather weather = new Weather();
			weather.setParkCode(results.getString("parkcode"));
			weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
			weather.setLowFahrenheit(results.getInt("low"));
			weather.setHighFahrenheit(results.getInt("high"));
			weather.setForecast(results.getString("forecast"));
			int lowFahr = weather.getLowFahrenheit();
			int lowCelcius = weather.deriveLowCelcius(lowFahr);
			weather.setLowCelcius(lowCelcius);
			int highFahr = weather.getHighFahrenheit();
			int highCelcius = weather.deriveHighCelcius(highFahr);
			weather.setHighCelcius(highCelcius);
			String forecast = weather.getForecast();
			String displayForecast = weather.makeDisplayForecast(forecast);
			weather.setDisplayForecast(displayForecast);
			String picAccessForecast = weather.makePicAccessForecast(forecast);
			weather.setPicAccessForecast(picAccessForecast);
			int fiveDayForecastValue = weather.getFiveDayForecastValue();
			String displayForecastValue = weather.makeDisplayForecastValue(fiveDayForecastValue);
			weather.setDisplayForecastValue(displayForecastValue);
			fiveDayForecast.add(weather);
		}
		return fiveDayForecast;
	}
	
	
}
