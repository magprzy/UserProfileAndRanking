package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.dao.BoardGamesCollectionDao;
import com.capgemini.userProfileAndRanking.entities.Game; 

@Repository
public class BoardGamesCollectionDaoImpl implements BoardGamesCollectionDao {
	
	private List<Game> boardGameCollection = new ArrayList<>();


	@Override
	public List<Game> getAllGames() {
		
		return boardGameCollection;
	}


	@Override
	public Game getGameByName(String gameName) {
		for (int i = 0; i< boardGameCollection.size(); i++){
			if(boardGameCollection.get(i).getGameName().equals(gameName)){
				return boardGameCollection.get(i);
			}
		}
		return null;
	}

	
	

	@Override
	public Game getGameById(int gameID) {
		for (int i = 0; i<boardGameCollection.size(); i++){
			if( boardGameCollection.get(i).getGameID() == gameID){
				return boardGameCollection.get(i);
			}
		}
		return null;
	}

	@Override
	public void addNewGame(Game newGame){
		boardGameCollection.add(newGame);
	}
	
	@Override
	public void updateUserList(Game newGame) {
		boardGameCollection.add(newGame);
		
	}
	
	public void exampleGames(){
		boardGameCollection.add(new Game(1, "Chess", "2 players"));
		boardGameCollection.add(new Game(2,"Ticket to Ride", "2 - 5 players"));
		boardGameCollection.add(new Game(3, "Splendor", "2 - 4 players"));
	}

	
}
