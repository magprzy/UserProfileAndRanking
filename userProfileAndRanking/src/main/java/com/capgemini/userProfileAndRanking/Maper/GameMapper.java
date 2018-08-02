package com.capgemini.userProfileAndRanking.maper;

import org.springframework.stereotype.Component;

import com.capgemini.userProfileAndRanking.entities.Game;
import com.capgemini.userProfileAndRanking.to.GameTO;

@Component
public class GameMapper {

	public GameTO mapToTO (Game gameEntity){
		
		GameTO gameTO = new GameTO();
		
		gameTO.setGameID(gameEntity.getGameID());
		gameTO.setGameName(gameEntity.getGameName());
		gameTO.setAdditionalInformation(gameEntity.getAdditionalInformation());
		
		return gameTO;
	}
	
	public Game mapToDAO(GameTO gameTO){
		
		Game gameEntity = new Game();
		
		gameEntity.setGameID(gameTO.getGameID());
		gameEntity.setGameName(gameTO.getGameName());
		gameEntity.setAdditionalInformation(gameTO.getAdditionalInformation());
		
		return gameEntity;
	}
}
