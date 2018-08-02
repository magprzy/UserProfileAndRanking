package com.capgemini.userProfileAndRanking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.userProfileAndRanking.Availability;
import com.capgemini.userProfileAndRanking.dao.impl.PlayabilityDaoImpl;
import com.capgemini.userProfileAndRanking.entities.Challenge;
import com.capgemini.userProfileAndRanking.entities.Playability;
import com.capgemini.userProfileAndRanking.service.PlayabilityService;

@Service
public class PlayabilityServiceImpl implements PlayabilityService {

	@Autowired
	PlayabilityDaoImpl playabilityDAO;

	@Override
	public void addUserAvailability(int userId, Availability availability) {
		Playability playability = new Playability();

		playability.setUserId(userId);
		playability.setAvailability(availability);
		playability.setStatusIsAvailable(true);

		playabilityDAO.addPlayability(playability);

	}

	@Override
	public void editUserAvailability(int userId, Availability newAvailability) {

		Playability userPlayability = playabilityDAO.getUserPlayability(userId);
		userPlayability.setAvailability(newAvailability);

		playabilityDAO.updatePlayability(userPlayability);

	}

	@Override
	public void removeUserAvailability(int userId, String comment) {
		Playability userPlayability = playabilityDAO.getUserPlayability(userId);
		userPlayability.setStatusIsAvailable(false);
		userPlayability.setComment(comment);

		playabilityDAO.updatePlayability(userPlayability);
	}

	@Override
	public List<Integer> getUsersWithSimilarAvailability(int userId) {
		Playability userPlayability = playabilityDAO.getUserPlayability(userId);
		Availability userAvailability = userPlayability.getAvailability();
		List<Integer> usersWithSimilarAvailability = playabilityDAO
				.getUsersByAvailability(userAvailability);

		usersWithSimilarAvailability.remove(userId);
		Challenge challenge = new Challenge();
		challenge.setUser1Id(userId);
		challenge.setUser2Id(usersWithSimilarAvailability.get(0));

		return usersWithSimilarAvailability;
	}

}
