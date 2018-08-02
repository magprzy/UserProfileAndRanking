package com.capgemini.userProfileAndRanking.to;

public class GameAndUserTO {
	private int userId;
	private int gameId;

	
	public GameAndUserTO(){
		
	}

	public GameAndUserTO(int userId, int gameId){
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
