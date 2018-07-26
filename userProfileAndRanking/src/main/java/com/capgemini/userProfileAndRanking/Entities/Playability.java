package com.capgemini.userProfileAndRanking.Entities;

import com.capgemini.userProfileAndRanking.Availability;

public class Playability {

	Availability availability;
	int userId;
	boolean statusIsAvailable;
	String comment;

	public boolean getStatusIsAvailable() {
		return statusIsAvailable;
	}

	public void setStatusIsAvailable(boolean statusIsAvailable) {
		this.statusIsAvailable = statusIsAvailable;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
