package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.Entities.User;
import com.capgemini.userProfileAndRanking.dao.UserProfileDao;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {

	List<User> listOfUsers = new ArrayList<User>();

	@Override
	public List<User> getAllUsers() {

		return listOfUsers;
	}

	@Override
	public User findUserById(int id) {

		for (int i = 0; i < listOfUsers.size(); i++) {
			if (listOfUsers.get(i).getId() == id) {
				return listOfUsers.get(i);
			}
		}
		return null;
	}
	
	public void exampleUsers () {
		listOfUsers.add(new User(1, "Jan", "Kowalski", "jkowalski@gmail.com" , "admin0101", "The best moment is right now"));
		listOfUsers.add(new User(2, "Adam", "Nowak", "anowak@gmail.com" , "kiwn49xs", "Hello world!"));
		listOfUsers.add(new User(3, "Kacper", "Kowalski", "kacpi@gmail.com" , "kacpi123", "YOLO"));
		listOfUsers.add(new User(4, "Daria", "Kurkiewicz", "darka@wp.com" , "haslo1993", "Trust me, I'm an engineer"));
		listOfUsers.add(new User(5, "Zofia", "Konieczna", "zofiak@gmail.com" , "password", "Carpe diem"));
	}

	@Override
	public void updateUser(User user) {
		for (int i = 0; i < listOfUsers.size(); i++){
			if( listOfUsers.get(i).getId() == user.getId())
				listOfUsers.set(i, user);
		}
		
		
	}


}
