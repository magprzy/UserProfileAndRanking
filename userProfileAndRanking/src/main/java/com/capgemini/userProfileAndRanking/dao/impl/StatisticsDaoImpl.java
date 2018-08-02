package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.Level;
import com.capgemini.userProfileAndRanking.dao.StatisticsDao;
import com.capgemini.userProfileAndRanking.entities.Statistics;

@Repository
public class StatisticsDaoImpl implements StatisticsDao {

	List<Statistics> listOfAllStatistics = new ArrayList<Statistics>();

	@Override
	public Statistics seeUserStatistics(int userId) {
		for (int i = 0; i < listOfAllStatistics.size(); i++) {
			if (listOfAllStatistics.get(i).getUserId() == userId) {
				return listOfAllStatistics.get(i);
			}
		}
		return null;
	}

	@Override
	public Level getLevelById(int userId) {

		
		return seeUserStatistics(userId).getLevel();
	}

	@Override
	public int getPositionById(int userId) {

		return seeUserStatistics(userId).getCurrentPosition();
	}

	@Override
	public List<Integer> getPreviousGamesById(int userId) {

		return seeUserStatistics(userId).getPreviousGames();
	}

	public void exampleStatistics(){
		
		List<Integer> previousGames1 = new ArrayList<>();
		List<Integer> previousGames2 = new ArrayList<>();
		List<Integer> previousGames3 = new ArrayList<>();
	
		
		previousGames1.add(3); previousGames1.add(2); previousGames1.add(4);
		previousGames2.add(2); previousGames2.add(1); previousGames2.add(3);
		previousGames3.add(2); previousGames3.add(3); previousGames3.add(4);
		
		
		
		listOfAllStatistics.add(new Statistics(1, Level.ADVANCED, 1, previousGames1));
		listOfAllStatistics.add(new Statistics(2, Level.BEGINER, 3, previousGames2));
		listOfAllStatistics.add(new Statistics(3, Level.INTERMEDIATE, 2, previousGames3));
	
		
		
		
	}

}
