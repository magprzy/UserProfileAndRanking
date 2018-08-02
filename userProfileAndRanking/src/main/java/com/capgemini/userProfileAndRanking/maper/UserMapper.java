package com.capgemini.userProfileAndRanking.maper;

import org.springframework.stereotype.Component;

import com.capgemini.userProfileAndRanking.entities.User;
import com.capgemini.userProfileAndRanking.to.UserTO;

@Component
public class UserMapper {
	public UserTO mapToTO(User userEntity){
		
		UserTO userTO = new UserTO();
		
		userTO.setId(userEntity.getId());
		userTO.setFirstName(userEntity.getFirstName());
		userTO.setLastName(userEntity.getLastName());
		userTO.setEmail(userEntity.getEmail());
		userTO.setPassword(userEntity.getPassword());
		userTO.setMotto(userEntity.getMotto());
		
		
		return userTO;
	}
	
	public User mapToEntity(UserTO userTO){
		
		User userEntity = new User();
		
		userEntity.setId(userTO.getId());
		userEntity.setFirstName(userTO.getFirstName());
		userEntity.setLastName(userTO.getLastName());
		userEntity.setEmail(userTO.getEmail());
		userEntity.setPassword(userTO.getPassword());
		userEntity.setMotto(userTO.getMotto());
	
		
		return userEntity;
	}
	
	
}
