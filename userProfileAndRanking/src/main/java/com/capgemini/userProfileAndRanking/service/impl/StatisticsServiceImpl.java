package com.capgemini.userProfileAndRanking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userProfileAndRanking.dao.impl.StatisticsDaoImpl;
import com.capgemini.userProfileAndRanking.entities.Statistics;
import com.capgemini.userProfileAndRanking.Level;
import com.capgemini.userProfileAndRanking.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	StatisticsDaoImpl statisticsDAO;
	
	@Override
	public Statistics seeUserCurrentStatistics(int userId) {
		
		return statisticsDAO.seeUserStatistics(userId);
	}

	@Override
	public Level getCurrentUserLevel(int userId) {
		
		return statisticsDAO.getLevelById(userId);
	}

	@Override
	public int getUserPosition(int userId) {
		
		return statisticsDAO.getPositionById(userId);
	}

	@Override
	public List<Integer> getUserPreviousGame(int userId) {
		
		return statisticsDAO.getPreviousGamesById(userId);
	}

}
