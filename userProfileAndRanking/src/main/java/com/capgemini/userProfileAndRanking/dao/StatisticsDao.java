package com.capgemini.userProfileAndRanking.dao;

import java.util.List;

import com.capgemini.userProfileAndRanking.Level;
import com.capgemini.userProfileAndRanking.Entities.Statistics;

public interface StatisticsDao {

	public Statistics seeUserStatistics(int userId);
	
	public Level getLevelById(int userId);
	
	public int getPositionById(int userId);
	
	public List<Integer> getPreviousGamesById(int userId);
}
