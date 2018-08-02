package com.capgemini.userProfileAndRanking.entities;

public class GameAndUser {
	private int userId;
	private int gameId;
	
	public GameAndUser(){
		
	}

	public GameAndUser(int userId, int gameId){
		this.userId = userId;
		this.gameId = gameId;
		
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
