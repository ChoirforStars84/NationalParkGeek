package com.techelevator.npgeek.model;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private String displayForecastValue; //Derived
	private int lowFahrenheit;
	private int lowCelcius; // Derived
	private int highFahrenheit;
	private int highCelcius; // Derived
	private String forecast;
	private String displayForecast; // Derived
	private String picAccessForecast; // Derived
	private boolean isFahrenheit;

	// Getters and Setters

	public boolean isFahrenheit() {
		return isFahrenheit;
	}

	public void setFahrenheit(boolean isFahrenheit) {
		this.isFahrenheit = isFahrenheit;
	}

	public int getLowFahrenheit() {
		return lowFahrenheit;
	}

	public void setLowFahrenheit(int lowFahrenheit) {
		this.lowFahrenheit = lowFahrenheit;
	}

	public int getHighFahrenheit() {
		return highFahrenheit;
	}

	public void setHighFahrenheit(int highFahrenheit) {
		this.highFahrenheit = highFahrenheit;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public void setLowCelcius(int lowCelcius) {
		this.lowCelcius = lowCelcius;
	}

	public void setHighCelcius(int highCelcius) {
		this.highCelcius = highCelcius;
	}

	public String getDisplayForecast() {
		return displayForecast;
	}

	public void setDisplayForecast(String displayForecast) {
		this.displayForecast = displayForecast;
	}

	public String getPicAccessForecast() {
		return picAccessForecast;
	}

	public void setPicAccessForecast(String picAccessForecast) {
		this.picAccessForecast = picAccessForecast;
	}

	public int getLowCelcius() {
		return lowCelcius;
	}

	public int getHighCelcius() {
		return highCelcius;
	}
	
	public String getDisplayForecastValue() {
		return displayForecastValue;
	}

	public void setDisplayForecastValue(String displayForecastValue) {
		this.displayForecastValue = displayForecastValue;
	}
	
	// Derived attribute methods

	public int deriveLowCelcius(int lowFahrenheit) {
		int lowCelcius = (lowFahrenheit - 32) * (5 / 9);
		return lowCelcius;
	}

	public int deriveHighCelcius(int highFahrenheit) {
		int highCelcius = (highFahrenheit - 32) * (5 / 9);
		return highCelcius;
	}

	public String makeDisplayForecast(String forecast) {
		String displayForecast = "";
		switch (forecast) {
			case "cloudy": displayForecast = "Cloudy";
			break;
			case "partly cloudy": displayForecast = "Partly Cloudy";
			break;
			case "rain": displayForecast = "Rain";
			break;
			case "snow": displayForecast = "Snow";
			break;
			case "sunny": displayForecast = "Sunny";
			break;
			case "thunderstorms": displayForecast = "Thunderstorms";
			break;
		}
		return displayForecast;
	}
	
	public String makePicAccessForecast(String forecast) {
		String picAccessForecast = "";
		if (forecast.equals("partly cloudy")) {
			picAccessForecast = "partlyCloudy";
		} else {
			picAccessForecast = forecast;
		}
		return picAccessForecast;
	}
	
	public String makeDisplayForecastValue(int fiveDayForecastValue) {
		String displayForecastValue = "";
		if (fiveDayForecastValue == 1) {
			displayForecastValue = "Today";
		} else if (fiveDayForecastValue == 2) {
			displayForecastValue = "Tomorrow";
		} else {
			String valueStr = Integer.toString(fiveDayForecastValue);
			displayForecastValue = "Day " + valueStr;
		}
		return displayForecastValue;
	}

}
