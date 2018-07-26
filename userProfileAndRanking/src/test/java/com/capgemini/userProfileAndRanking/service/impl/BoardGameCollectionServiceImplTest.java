package com.capgemini.userProfileAndRanking.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.userProfileAndRanking.TO.GameTO;
import com.capgemini.userProfileAndRanking.dao.impl.BoardGamesCollectionDaoImpl;
import com.capgemini.userProfileAndRanking.dao.impl.UserBoardGamesDaoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardGameCollectionServiceImplTest {

	@Autowired
	BoardGameCollectionServiceImpl boardGameCollectionServiceImpl;
	
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
		
		
		List<GameTO> result = boardGameCollectionServiceImpl.seeOwnGames(1);
		
		assertEquals("Chess", result.get(0).getGameName());
		
	}
}
