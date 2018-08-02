package com.capgemini.userProfileAndRanking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userProfileAndRanking.dao.impl.UserProfileDaoImpl;
import com.capgemini.userProfileAndRanking.entities.User;
import com.capgemini.userProfileAndRanking.maper.UserMapper;
import com.capgemini.userProfileAndRanking.service.UserProfileService;
import com.capgemini.userProfileAndRanking.to.UserTO;

@Service
public class UserProfileServiceImpl implements UserProfileService{

	private UserProfileDaoImpl userDAO;
	private UserMapper userMaper;
	
	
	
	
	@Autowired
	public UserProfileServiceImpl(UserProfileDaoImpl userDAO, UserMapper userMapper) {
	
		this.userDAO = userDAO;
		this.userMaper = userMapper;
	}
	
	@Override
	public UserTO getPlayerInformation(int userId) {
		User user = userDAO.getUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		
		return userTO;
	} 
	

	@Override
	public void changeFirstName(int userId, String newFirstName) {
		User user = userDAO.getUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setFirstName(newFirstName);
		saveChanges(userTO);
	}

	@Override
	public void changeLastName(int userId, String newLastName) {
		User user = userDAO.getUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setLastName(newLastName);
		saveChanges(userTO);
		
	}

	@Override
	public void changeEmail(int userId, String newEmail) {
		User user = userDAO.getUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setEmail(newEmail);
		saveChanges(userTO);
		
	}

	@Override
	public void changePassword(int userId, String newPassword) {
		User user = userDAO.getUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setPassword(newPassword);
		saveChanges(userTO);
		
	}

	@Override
	public void changeMotto(int userId, String newChangeMotto) {
		User user = userDAO.getUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setMotto(newChangeMotto);
		saveChanges(userTO);
		
	}
	
	private void saveChanges(UserTO userTO){
		User userEntity = userMaper.mapToEntity(userTO);
		userDAO.updateUser(userEntity);
	}

	
	public List<UserTO> getAllUSers(){
		List<UserTO > users = new ArrayList<>();
		
		 for(User user: userDAO.getAllUsers()){
			UserTO userTO = userMaper.mapToTO(user);
			users.add(userTO);
			
		 }	
		
		return users;
	}
	
	public void addUser(UserTO userTo){
		userDAO.addUser(userMaper.mapToEntity(userTo));
	}

	public List<UserTO>  getUserByParameters(String firstName, String lastName, String email){
		
		List <User> users = userDAO.getByParameters(firstName, lastName, email);
		List<UserTO> usersTO = new ArrayList<>();
		for( User userEntity: users){
			UserTO userTo = userMaper.mapToTO(userEntity);
			usersTO.add(userTo);
		}
		
		return usersTO;
	}
	

	

}
