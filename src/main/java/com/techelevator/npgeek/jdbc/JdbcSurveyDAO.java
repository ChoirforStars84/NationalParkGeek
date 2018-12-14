package com.techelevator.npgeek.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.techelevator.npgeek.dao.SurveyDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyResults;

@Repository
public class JdbcSurveyDAO implements SurveyDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveSurveyResults(Survey survey) {
		String sqlGetNextId = "SELECT nextval('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetNextId);
		results.next();
		int id = results.getInt(1);
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, id, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
	}
	
	public List<SurveyResults> getSurveySearchResults(){
		List<SurveyResults> favsList = new ArrayList<SurveyResults>();
		String sqlSelectSurveyResults = "SELECT COUNT(survey_result.parkcode) AS votes, park.parkname, survey_result.parkcode " +
				"FROM survey_result JOIN park ON survey_result.parkcode=park.parkcode " +
				"GROUP BY survey_result.parkcode, park.parkname " +
				"ORDER BY votes DESC, park.parkname ASC;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectSurveyResults);
		while(results.next()) {
			SurveyResults favs = new SurveyResults();
			favs.setParkCode(results.getString("parkcode").toLowerCase());
			favs.setParkName(results.getString("parkname"));
			favs.setSurveyCount(results.getInt("votes"));
			favsList.add(favs);
		}
		return favsList;
	}
	
	/*private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}*/
}
