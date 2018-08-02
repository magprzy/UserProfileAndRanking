package com.capgemini.userProfileAndRanking.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.activity.InvalidActivityException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.userProfileAndRanking.dao.impl.BoardGamesCollectionDaoImpl;
import com.capgemini.userProfileAndRanking.dao.impl.UserBoardGamesDaoImpl;
import com.capgemini.userProfileAndRanking.to.GameTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardGameCollectionServiceImplTest {

	@Autowired
	BoardGameCollectionServiceImpl gameCollectionService;
	
	@Autowired
	BoardGamesCollectionDaoImpl systemGames;
	
	@Autowired
	UserBoardGamesDaoImpl userGames;
	

	
	@Test
	public void shouldReturnUserBoardGamesIdCollection(){
		systemGames.exampleGames();
		userGames.exapmleUserAndGamesID();
		
		
		List<Integer> result = userGames.getUserBoardGamesIdCollection(1);		
		assertEquals(new Integer(1), result.get(0));
		
	}
	
	
	@Test
	public void shouldReturnUserGames(){
		systemGames.exampleGames();
		userGames.exapmleUserAndGamesID();
		
		
		List<GameTO> result = gameCollectionService.seeOwnGames(1);
		
		assertEquals("Chess", result.get(0).getGameName());
		assertEquals(1, result.size());
		
	}
	
	@Test 
	public void shouldReturnAllSystemGames(){
		systemGames.exampleGames();
		
		List<GameTO> result = gameCollectionService.seeAllSystemGames();
		
		assertEquals("Chess", result.get(0).getGameName());
		assertEquals("Ticket to Ride", result.get(1).getGameName());
		assertEquals("Splendor", result.get(2).getGameName());
		
	}
	
	@Test
	public void shouldAddGameToSystem() throws InvalidActivityException{
		systemGames.exampleGames();
		
		gameCollectionService.addNewGameToSystem(new GameTO(4, "Taboo", "party game"));
		
		List<GameTO> result = gameCollectionService.seeAllSystemGames();
		
		assertEquals("Taboo", result.get(3).getGameName());
	}
}

