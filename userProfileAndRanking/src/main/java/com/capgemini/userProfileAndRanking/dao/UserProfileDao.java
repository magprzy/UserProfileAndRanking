package com.capgemini.userProfileAndRanking.dao;

import java.util.List;

import com.capgemini.userProfileAndRanking.entities.User;


public interface UserProfileDao {

	 List<User> getAllUsers();
	
	 User getUserById(int id);
	
	 void updateUser(User user);

	 List<User> getByParameters(String firstName, String lastName, String email);
	
	
}
