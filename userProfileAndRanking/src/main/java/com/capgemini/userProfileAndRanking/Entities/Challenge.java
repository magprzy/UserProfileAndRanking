package com.capgemini.userProfileAndRanking.entities;

public class Challenge {

	int user1Id;
	int user2Id;
	
	public Challenge(){
		
	}
	
	public Challenge(int user1Id, int user2Id){
		this.user1Id = user1Id;
		this.user2Id = user2Id;
	}

	public int getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}

	public int getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}
	
}
