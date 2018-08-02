package com.capgemini.userProfileAndRanking.dao.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.capgemini.userProfileAndRanking.entities.User;

public class UserProfileDaoImplTest {

	@Test
	public void shouldFindUserById() {
		// given
		UserProfileDaoImpl userProfile = new UserProfileDaoImpl();
		userProfile.exampleUsers();
		
		// then
		User result = userProfile.getUserById(5);
		
		//when
		assertEquals("Zofia", result.getFirstName());

	}


	@Test 
	public void shouldFindUserByLastName(){
		//given
		UserProfileDaoImpl userProfile = new UserProfileDaoImpl();
		userProfile.exampleUsers();
		
		//then
		List<User> users = userProfile.getByParameters(null, "Kowalski", null);
		
		//when
		assertEquals(3, users.size());
		assertEquals("Jan", users.get(0).getFirstName());
		assertEquals("Kacper", users.get(1).getFirstName());
		assertEquals("Adam", users.get(2).getFirstName());
		
		
	}
}
