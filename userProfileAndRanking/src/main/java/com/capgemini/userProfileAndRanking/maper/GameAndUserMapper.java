package com.capgemini.userProfileAndRanking.maper;

import org.springframework.stereotype.Component;

import com.capgemini.userProfileAndRanking.entities.GameAndUser;
import com.capgemini.userProfileAndRanking.to.GameAndUserTO;

@Component
public class GameAndUserMapper {

	public GameAndUserTO mapToTO (GameAndUser gameAndUserEntity){
		
		GameAndUserTO gameAndUserTO = new GameAndUserTO();
		
		gameAndUserTO.setGameId(gameAndUserEntity.getGameId());
		gameAndUserTO.setUserId(gameAndUserEntity.getUserId());
		
		return gameAndUserTO;
		
	}
	
	public GameAndUser mapToDAO (GameAndUserTO gameAndUserTO){
		
		GameAndUser gameAndUserEntity = new GameAndUser();
		
		gameAndUserEntity.setGameId(gameAndUserTO.getGameId());
		gameAndUserEntity.setGameId(gameAndUserTO.getUserId());
		
		return gameAndUserEntity;
	}
}
