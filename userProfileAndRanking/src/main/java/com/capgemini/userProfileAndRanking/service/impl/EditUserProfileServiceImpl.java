package com.capgemini.userProfileAndRanking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userProfileAndRanking.Entities.User;
import com.capgemini.userProfileAndRanking.Maper.UserMapper;
import com.capgemini.userProfileAndRanking.TO.UserTO;
import com.capgemini.userProfileAndRanking.dao.impl.UserProfileDaoImpl;
import com.capgemini.userProfileAndRanking.service.EditUserProfileService;

@Service
public class EditUserProfileServiceImpl implements EditUserProfileService{

	private UserProfileDaoImpl userDAO;
	private UserMapper userMaper;
	
	@Autowired
	public EditUserProfileServiceImpl(UserProfileDaoImpl userDAO, UserMapper userMapper) {
		this.userDAO = userDAO;
		this.userMaper = userMapper;
	}
	
	@Override
	public UserTO checkPlayerInformation(int userId) {
		User user = userDAO.findUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		
		return userTO;
	} 
	

	@Override
	public void changeFirstName(int userId, String newFirstName) {
		User user = userDAO.findUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setFirstName(newFirstName);
		saveChanges(userTO);
	}

	@Override
	public void changeLastName(int userId, String newLastName) {
		User user = userDAO.findUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setLastName(newLastName);
		saveChanges(userTO);
		
	}

	@Override
	public void changeEmail(int userId, String newEmail) {
		User user = userDAO.findUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setEmail(newEmail);
		saveChanges(userTO);
		
	}

	@Override
	public void changePassword(int userId, String newPassword) {
		User user = userDAO.findUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setPassword(newPassword);
		saveChanges(userTO);
		
	}

	@Override
	public void changeMotto(int userId, String newChangeMotto) {
		User user = userDAO.findUserById(userId);
		UserTO userTO = userMaper.mapToTO(user);
		userTO.setMotto(newChangeMotto);
		saveChanges(userTO);
		
	}
	
	private void saveChanges(UserTO userTO){
		User userEntity = userMaper.mapToEntity(userTO);
		userDAO.updateUser(userEntity);
	}


	

	

}
