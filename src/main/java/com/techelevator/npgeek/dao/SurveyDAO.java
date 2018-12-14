package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResults;

public interface SurveyDAO {
		
		public void saveSurveyResults(Survey survey);
	
		public List<SurveyResults> getSurveySearchResults();
			
}
