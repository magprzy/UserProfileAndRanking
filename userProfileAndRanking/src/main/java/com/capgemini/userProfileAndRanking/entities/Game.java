package com.capgemini.userProfileAndRanking.entities;

public class Game {
	
	private int gameID;
	private String gameName;
	private String additionalInformation;

	
	public Game(){
		
	}
	public Game( int gameId, String gameName, String additionalInformation) {
		this.gameName = gameName;
		this.gameID = gameId;
		this.additionalInformation = additionalInformation;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

}
