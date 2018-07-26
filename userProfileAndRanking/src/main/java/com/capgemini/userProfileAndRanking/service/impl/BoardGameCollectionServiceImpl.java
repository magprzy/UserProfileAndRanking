package com.capgemini.userProfileAndRanking.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.activity.InvalidActivityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userProfileAndRanking.Entities.Game;
import com.capgemini.userProfileAndRanking.Entities.GameAndUser;
import com.capgemini.userProfileAndRanking.Maper.GameAndUserMapper;
import com.capgemini.userProfileAndRanking.Maper.GameMapper;
import com.capgemini.userProfileAndRanking.TO.GameAndUserTO;
import com.capgemini.userProfileAndRanking.TO.GameTO;
import com.capgemini.userProfileAndRanking.dao.impl.BoardGamesCollectionDaoImpl;
import com.capgemini.userProfileAndRanking.dao.impl.UserBoardGamesDaoImpl;
import com.capgemini.userProfileAndRanking.service.BoardGameCollectionService;

@Service
public class BoardGameCollectionServiceImpl
		implements BoardGameCollectionService {

	@Autowired
	private BoardGamesCollectionDaoImpl gameCollectionDAO;
	@Autowired
	private GameMapper gameMapper;
	@Autowired
	private GameAndUserMapper gameAndUserMapper;
	@Autowired
	private UserBoardGamesDaoImpl userBoardGamesIdListDAO;
	
	private GameAndUserTO gameAndUserTO;

	

	@Override
	public List<GameTO> seeOwnGames(int userId) {

		List<GameTO> userBoardGamesCollection = new ArrayList<GameTO>();
		List<Integer> userGamesIdCollectionDAO = userBoardGamesIdListDAO.getUserBoardGamesIdCollection(userId);
		for (int i = 0; i < userGamesIdCollectionDAO.size(); i++) {
			int currentGameId = userGamesIdCollectionDAO.get(i);

			userBoardGamesCollection.add(gameMapper
					.mapToTO(gameCollectionDAO.getGameById(currentGameId)));

		}

		return userBoardGamesCollection;
	}

	public List<GameTO> seeAllSystemGames() {
		List<Game> allGames = new ArrayList<Game>();
		allGames = gameCollectionDAO.getAllGames();

		List<GameTO> allSystemGamesTO = new ArrayList<GameTO>();

		for (int i = 0; i < allGames.size(); i++) {
			allSystemGamesTO.add(gameMapper.mapToTO(allGames.get(i)));
		}

		return allSystemGamesTO;
	}

	@Override
	public String findOutMoreAboutGame(String gameName) {

		GameTO gameTO = gameMapper
				.mapToTO(gameCollectionDAO.getGameByName(gameName));

		String information = gameTO.getAdditionalInformation();

		return information;
	}

	@Override
	public void addNewGameToUserList(int userId, GameTO newGame) {

		List<GameTO> systemGamesCollection = new ArrayList<GameTO>();
		systemGamesCollection = seeAllSystemGames();

		int gameId = 0;

		for (int i = 0; i < systemGamesCollection.size(); i++) {
			if (systemGamesCollection.get(i).getGameName().equals(newGame
					.getGameName())) {
				gameId = systemGamesCollection.get(i).getGameID();
			} else {
				throw new NoSuchElementException();
			}
		}
		gameAndUserTO.setGameId(gameId);
		gameAndUserTO.setUserId(userId);

		saveAddedGame(gameAndUserTO);
	}

	private void saveAddedGame(GameAndUserTO gameAndUserTO) {
		GameAndUser gameAndUserEntity = gameAndUserMapper
				.mapToDAO(gameAndUserTO);
		userBoardGamesIdListDAO.addNewGameToUser(gameAndUserEntity);
	}

	@Override
	public void removeGameFromUserList(int userId, GameTO removeGame) {
		int gameId = removeGame.getGameID();
		gameAndUserTO.setGameId(gameId);
		gameAndUserTO.setUserId(userId);

		saveRemovedGame(gameAndUserTO);

	}

	private void saveRemovedGame(GameAndUserTO gameAndUserTO) {
		GameAndUser gameAndUserEntity = gameAndUserMapper
				.mapToDAO(gameAndUserTO);
		userBoardGamesIdListDAO.removeGameFromUser(gameAndUserEntity);
	}

	@Override
	public void addNewGameToSystem(GameTO newGameTO)
			throws InvalidActivityException {
		List<GameTO> allSystemGames = seeAllSystemGames();
		boolean gameExistIsSystem = false;

		for (int i = 0; i < allSystemGames.size(); i++) {
			if (allSystemGames.get(i).equals(newGameTO)) {
				gameExistIsSystem = true;
			}
		}

		if (gameExistIsSystem == false) {
			Game newGameEntity = gameMapper.mapToDAO(newGameTO);
			gameCollectionDAO.addNewGame(newGameEntity);
		} else {
			throw new InvalidActivityException();
		}

	}

}
