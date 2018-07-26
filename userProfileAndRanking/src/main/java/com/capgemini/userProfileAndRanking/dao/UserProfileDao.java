package com.capgemini.userProfileAndRanking.dao;

import java.util.List;

import com.capgemini.userProfileAndRanking.Entities.User;


public interface UserProfileDao {

	public List<User> getAllUsers();
	
	public User findUserById(int id);
	
	public void updateUser(User user);
		
	
	
	
}
