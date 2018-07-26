package com.capgemini.userProfileAndRanking.service;

import java.util.List;

import com.capgemini.userProfileAndRanking.Availability;

public interface PlayabilityService {

	public void addUserAvailability(int userId, Availability availability);
	
	public void editUserAvailability(int userId, Availability newAvailability);
	
	public void removeUserAvailability(int userID, String comment);
	
	public List <Integer> getUsersWithSimilarAvailability(int userId);
	
	
	
	
	
	
}
