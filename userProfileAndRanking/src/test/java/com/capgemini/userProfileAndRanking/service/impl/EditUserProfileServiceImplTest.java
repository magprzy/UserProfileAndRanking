package com.capgemini.userProfileAndRanking.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.userProfileAndRanking.dao.impl.UserProfileDaoImpl;
import com.capgemini.userProfileAndRanking.to.UserTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditUserProfileServiceImplTest {

	@Autowired
	UserProfileServiceImpl editUserProfileServiceImpl;
	
	@Autowired
	UserProfileDaoImpl UserProfileDaoImpl;

	
	@Test
	public void shouldGetAllPlayerInformation() {
		
		
		UserTO result = editUserProfileServiceImpl.getPlayerInformation(2);
		assertEquals(2, result.getId());
		assertEquals("Adam", result.getFirstName());
		assertEquals("Nowak", result.getLastName());
		assertEquals("anowak@gmail.com", result.getEmail());
		assertEquals("kiwn49xs", result.getPassword());
		assertEquals("Hello world!", result.getMotto());
		
	}
	@Test
	public void shouldChangeFirstName() {
		
		
		editUserProfileServiceImpl.changeFirstName(5, "Filip");
		UserTO result = editUserProfileServiceImpl.getPlayerInformation(5);
		assertEquals("Filip", result.getFirstName());
	}
	
	
	@Test
	public void shouldChangeLastName() {
		
		
		editUserProfileServiceImpl.changeLastName(5, "Nawrocka");
		UserTO result = editUserProfileServiceImpl.getPlayerInformation(5);
		assertEquals("Nawrocka", result.getLastName());
	}
	
	@Test
	public void shouldChangeEmail() {
		
		
		editUserProfileServiceImpl.changeEmail(5, "email@email.com");
		UserTO result = editUserProfileServiceImpl.getPlayerInformation(5);
		assertEquals("email@email.com", result.getEmail());
	}
	
	@Test
	public void shouldChangePassword() {
		
		
		editUserProfileServiceImpl.changePassword(5, "qwertz");
		UserTO result = editUserProfileServiceImpl.getPlayerInformation(5);
		assertEquals("qwertz", result.getPassword());
	}
	
	@Test
	public void shouldChangeMotto() {
		
		
		editUserProfileServiceImpl.changeMotto(5, "U mnie dziala");
		UserTO result = editUserProfileServiceImpl.getPlayerInformation(5);
		assertEquals("U mnie dziala", result.getMotto());
	}
	

	
}
