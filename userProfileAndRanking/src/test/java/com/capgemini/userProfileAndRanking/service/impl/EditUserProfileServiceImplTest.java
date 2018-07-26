package com.capgemini.userProfileAndRanking.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.userProfileAndRanking.TO.UserTO;
import com.capgemini.userProfileAndRanking.dao.impl.UserProfileDaoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EditUserProfileServiceImplTest {

	@Autowired
	EditUserProfileServiceImpl editUserProfileServiceImpl;
	
	@Autowired
	UserProfileDaoImpl UserProfileDaoImpl;

	
	@Test
	public void shouldGetAllPlayerInformation() {
		
		UserProfileDaoImpl.exampleUsers();
		UserTO result = editUserProfileServiceImpl.checkPlayerInformation(2);
		assertEquals(2, result.getId());
		assertEquals("Adam", result.getFirstName());
		assertEquals("Nowak", result.getLastName());
		assertEquals("anowak@gmail.com", result.getEmail());
		assertEquals("kiwn49xs", result.getPassword());
		assertEquals("Hello world!", result.getMotto());
		
	}
	@Test
	public void shouldChangeFirstName() {
		
		UserProfileDaoImpl.exampleUsers();
		editUserProfileServiceImpl.changeFirstName(5, "Filip");
		UserTO result = editUserProfileServiceImpl.checkPlayerInformation(5);
		assertEquals("Filip", result.getFirstName());
	}
	
	
	@Test
	public void shouldChangeLastName() {
		
		UserProfileDaoImpl.exampleUsers();
		editUserProfileServiceImpl.changeLastName(5, "Nawrocka");
		UserTO result = editUserProfileServiceImpl.checkPlayerInformation(5);
		assertEquals("Nawrocka", result.getLastName());
	}
	
	@Test
	public void shouldChangeEmail() {
		
		UserProfileDaoImpl.exampleUsers();
		editUserProfileServiceImpl.changeEmail(5, "email@email.com");
		UserTO result = editUserProfileServiceImpl.checkPlayerInformation(5);
		assertEquals("email@email.com", result.getEmail());
	}
	
	@Test
	public void shouldChangePassword() {
		
		UserProfileDaoImpl.exampleUsers();
		editUserProfileServiceImpl.changePassword(5, "qwertz");
		UserTO result = editUserProfileServiceImpl.checkPlayerInformation(5);
		assertEquals("qwertz", result.getPassword());
	}
	
	@Test
	public void shouldChangeMotto() {
		
		UserProfileDaoImpl.exampleUsers();
		editUserProfileServiceImpl.changeMotto(5, "U mnie dziala");
		UserTO result = editUserProfileServiceImpl.checkPlayerInformation(5);
		assertEquals("U mnie dziala", result.getMotto());
	}
	

	
}
