package com.capgemini.userProfileAndRanking.entities;

import java.util.List;

import com.capgemini.userProfileAndRanking.Level;

public class Statistics {
	
	private int userId;
	private Level level;
	private int currentPosition;
	List<Integer> previousGames;
	
	public Statistics(){
		
	}
	
	public Statistics(int userId, Level level, int currentPosition, List<Integer> previousGames){
		this.userId = userId;
		this.level = level;
		this.currentPosition = currentPosition;
		this.previousGames = previousGames;
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	public List<Integer> getPreviousGames() {
		return previousGames;
	}
	public void setPreviousGames(List<Integer> previousGames) {
		this.previousGames = previousGames;
	}
	
	
}
