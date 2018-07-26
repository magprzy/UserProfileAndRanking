package com.capgemini.userProfileAndRanking.service;

import java.util.List;

import javax.activity.InvalidActivityException;

import com.capgemini.userProfileAndRanking.TO.GameTO;

public interface BoardGameCollectionService {
	
	public List<GameTO> seeOwnGames(int userId);
	
	public List<GameTO> seeAllSystemGames();
	
	public String findOutMoreAboutGame(String gameName);

	public void addNewGameToUserList(int userId, GameTO newGame);

	public void removeGameFromUserList(int userId, GameTO removeGame);

	public void addNewGameToSystem( GameTO newGameTO) throws InvalidActivityException;

}
