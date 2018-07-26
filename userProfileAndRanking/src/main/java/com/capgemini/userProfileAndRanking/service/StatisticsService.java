package com.capgemini.userProfileAndRanking.service;

import java.util.List;

import com.capgemini.userProfileAndRanking.Level;
import com.capgemini.userProfileAndRanking.Entities.Statistics;

public interface StatisticsService {

	public Statistics seeUserCurrentStatistics(int userId);
	
	public Level getCurrentUserLevel(int userId);
	
	public int getUserPosition(int userId);
	
	public List<Integer> getUserPreviousGame(int userId);
	

}
