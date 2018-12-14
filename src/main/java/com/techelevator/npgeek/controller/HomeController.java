package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.jdbc.JdbcParkDAO;
import com.techelevator.npgeek.jdbc.JdbcWeatherDAO;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;

@Controller
@SessionAttributes("weatherSession")
public class HomeController {
	
	@Autowired
	private JdbcParkDAO ParkDAO;
	
	@Autowired
	private JdbcWeatherDAO WeatherDAO;
	    
	@RequestMapping(path={"/homePage", "/"}, method=RequestMethod.GET)
	public String displayHomePage(HttpServletRequest request) {
	    request.setAttribute("parkList", ParkDAO.getAllParks());
	    return "homePage";
	}
	
	@RequestMapping("/detailPage")
	public String displayDetailAndWeatherPage(HttpServletRequest request, ModelMap model) {
		String parkCode = request.getParameter("parkCode");
        Park park = ParkDAO.getParkInfo(parkCode);
        List<Weather> weather = WeatherDAO.getFiveDayForecast(parkCode);
        request.setAttribute("park", park);
        request.setAttribute("weather", weather);
		return "detailPage";
	}
	
	/*@RequestMapping(path="/detailPage", method=RequestMethod.POST)
	public String setTempScale(@RequestParam)*/
	
	
}
