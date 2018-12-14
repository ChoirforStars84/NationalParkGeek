package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.jdbc.JdbcSurveyDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResults;

@Controller
@SessionAttributes("detailSession")
public class SurveyController {
	
	@Autowired
	private JdbcSurveyDAO SurveyDAO;
	
	@RequestMapping(path="/favoritesPage", method=RequestMethod.POST)
	public String submitPost(HttpServletRequest req) {
		Survey survey = new Survey();
		survey.setParkCode(req.getParameter("parkName"));
		survey.setEmailAddress(req.getParameter("emailaddress"));
		survey.setState(req.getParameter("statename"));
		survey.setActivityLevel(req.getParameter("activitylevel"));
		SurveyDAO.saveSurveyResults(survey);
		SurveyDAO.getSurveySearchResults();
	return "redirect:/favoritesPage";
	}
	
	//I think this is the problem for the surveys not saving to the database. I know the SQL works, but not sure how the methods are being called.
	
	
	@RequestMapping(path="/surveyPage", method=RequestMethod.GET) 
    public String displaySurveyInputPage() {
        return "surveyPage";
    }
	
	@RequestMapping(path="/favoritesPage", method=RequestMethod.GET)
	public String displayFavorites(HttpServletRequest request) {
		List<SurveyResults> surveyResults = SurveyDAO.getSurveySearchResults();
		request.setAttribute("favorites", surveyResults);
		
		return "favoritesPage";
	}

}
