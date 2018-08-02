package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.dao.UserBoardGamesDao;
import com.capgemini.userProfileAndRanking.entities.GameAndUser;

@Repository
public class UserBoardGamesDaoImpl implements UserBoardGamesDao{

	List<GameAndUser> gameAndUsersList = new ArrayList<>();
	
	@Override
	public List<Integer> getUserBoardGamesIdCollection(int userId) {
		
		List<Integer> userBoardGamesIdCollection = new ArrayList<Integer>();
		
		for (int i = 0; i < gameAndUsersList.size(); i++){
			if(gameAndUsersList.get(i).getUserId() == userId){
				userBoardGamesIdCollection.add(gameAndUsersList.get(i).getGameId());
			}			
		}
		
		return userBoardGamesIdCollection;
	}
	
	public void addNewGameToUser(GameAndUser gameAndUser){
		gameAndUsersList.add(gameAndUser);
	}
	
	public void removeGameFromUser(GameAndUser gameAndUser){
		gameAndUsersList.remove(gameAndUser);
	}
	
	public void exapmleUserAndGamesID(){
		
		gameAndUsersList.add(new GameAndUser(2,1));
		gameAndUsersList.add(new GameAndUser(2,3));
		gameAndUsersList.add(new GameAndUser(1,1));
		gameAndUsersList.add(new GameAndUser(5,3));
	}
}
