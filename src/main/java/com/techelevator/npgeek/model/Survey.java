package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private Long surveyID;
	
	@NotBlank(message="Park is required")
	private String parkCode;
	
	@NotBlank(message="Email is required")
	@Email(message="Email must be a valid email address")
	@Size(max=100, message="Email address cannot be over 100 characters")
	private String emailAddress;
	
	@NotBlank(message="State is required")
	private String state;
	
	@NotBlank(message="Activity level is required")
	private String activityLevel;
	
	public Long getSurveyID() {
		return surveyID;
	}
	public void setSurveyID(Long surveyID) {
		this.surveyID = surveyID;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	

}
