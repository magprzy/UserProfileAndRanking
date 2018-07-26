package com.capgemini.userProfileAndRanking.dao;

import java.util.List;

import com.capgemini.userProfileAndRanking.Entities.Game;

public interface BoardGamesCollectionDao {

	public List<Game> getAllGames();

	public Game getGameByName(String gameName);
	
	public Game getGameById(int gameID);
	
	public void updateUserList (Game newGame);

}
