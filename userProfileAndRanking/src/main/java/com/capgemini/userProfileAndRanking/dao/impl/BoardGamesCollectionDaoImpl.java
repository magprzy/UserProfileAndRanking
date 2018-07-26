package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.Entities.Game;
import com.capgemini.userProfileAndRanking.dao.BoardGamesCollectionDao; 

@Repository
public class BoardGamesCollectionDaoImpl implements BoardGamesCollectionDao {
	
	private List<Game> boardGameCollection;


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

	
	public void exampleGames(){
		boardGameCollection.add(new Game("Ticket to Ride"));
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

	public void addNewGame(Game newGame){
		boardGameCollection.add(newGame);
	}
	
	@Override
	public void updateUserList(Game newGame) {
		boardGameCollection.add(newGame);
		
	}
	
}
