package com.capgemini.userProfileAndRanking.dao.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capgemini.userProfileAndRanking.Entities.User;

public class UserProfileDaoImplTest {

	@Test
	public void shouldFindUserById() {
		// given
		UserProfileDaoImpl userProfile = new UserProfileDaoImpl();
		userProfile.exampleUsers();
		
		// then
		User result = userProfile.findUserById(5);
		
		//when
		assertEquals("Zofia", result.getFirstName());

	}



}
