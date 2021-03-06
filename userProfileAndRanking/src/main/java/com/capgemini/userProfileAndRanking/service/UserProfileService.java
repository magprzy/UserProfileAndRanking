package com.capgemini.userProfileAndRanking.service;

import com.capgemini.userProfileAndRanking.to.UserTO;

public interface UserProfileService {
	
	public UserTO getPlayerInformation(int userId);
	
	public void changeFirstName(int userId, String newFirstName);
	
	public void changeLastName(int userId, String newLastName );
	
	public void changeEmail(int userId, String newEmail);
	
	public void changePassword(int userId, String newPassword);
		
	public void changeMotto(int userId, String newChangeMotto);
	
	
	
}
