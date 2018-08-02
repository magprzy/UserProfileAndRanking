package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.dao.UserProfileDao;
import com.capgemini.userProfileAndRanking.entities.User;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {

	List<User> listOfUsers = new ArrayList<User>();

	

	@Override
	public List<User> getAllUsers() {
		
		return listOfUsers;
	}

	@Override
	public User getUserById(int id) {

		List<User> users = listOfUsers.stream().filter(i -> i.getId() == id).collect(Collectors.toList());
		
		return users.get(0);
	}
	
	@PostConstruct
	public void exampleUsers () {
		
		listOfUsers.add(new User(1, "Jan", "Kowalski", "jkowalski@gmail.com" , "admin0101", "The best moment is right now"));
		listOfUsers.add(new User(2, "Adam", "Nowak", "anowak@gmail.com" , "kiwn49xs", "Hello world!"));
		listOfUsers.add(new User(3, "Kacper", "Kowalski", "kacpi@gmail.com" , "kacpi123", "YOLO"));
		listOfUsers.add(new User(4, "Daria", "Kurkiewicz", "darka@wp.com" , "haslo1993", "Trust me, I'm an engineer"));
		listOfUsers.add(new User(5, "Zofia", "Konieczna", "zofiak@gmail.com" , "password", "Carpe diem"));
		listOfUsers.add(new User(6, "Adam", "Kowalski", "adamk@gmail.com" , "password", "Winter is coming"));
		
	}

	@Override
	public void updateUser(User user) {
		for (int i = 0; i < listOfUsers.size(); i++){
			if( listOfUsers.get(i).getId() == user.getId())
				listOfUsers.set(i, user);
		}
		
	}

	public List<User> getByParameters(String firstName, String lastName, String email){
		
		
		List<User> users = listOfUsers.stream().filter(f-> f.getFirstName().equals(firstName ) || firstName.isEmpty())
				.filter(l-> l.getLastName().equals(lastName) || lastName.isEmpty() )
				.filter(e-> e.getLastName().equals(email) || email.isEmpty() )
				.collect(Collectors.toList());	
		
		return users;
	}
	
	public void addUser(User user){
		listOfUsers.add(user);
	}


}
