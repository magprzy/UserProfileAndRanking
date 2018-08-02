package com.capgemini.userProfileAndRanking.to;

public class GameTO {
	
	private int gameID;
	private String gameName;
	private String additionalInformation;

	public GameTO(){
		
	}
	
	public GameTO(int gameId, String gameName, String additionalInformation) {
		this.gameName = gameName;

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
