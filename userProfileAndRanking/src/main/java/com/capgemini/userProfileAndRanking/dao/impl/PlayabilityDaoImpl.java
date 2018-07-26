package com.capgemini.userProfileAndRanking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.userProfileAndRanking.Availability;
import com.capgemini.userProfileAndRanking.Entities.Playability;
import com.capgemini.userProfileAndRanking.dao.PlayabilityDao;

@Repository
public class PlayabilityDaoImpl implements PlayabilityDao {

	List<Playability> playabilityList = new ArrayList<Playability>();

	@Override
	public List<Playability> getAllPlayailities() {
		return playabilityList;
	}

	@Override
	public void addPlayability(Playability playability) {
		playabilityList.add(playability);

	}

	public void updatePlayability(Playability newPlayability) {
		for (int i = 0; i < playabilityList.size(); i++) {
			if (playabilityList.get(i).getUserId() == newPlayability
					.getUserId()) {
				playabilityList.set(i, newPlayability);
			}
		}
	}

	@Override
	public Playability getUserPlayability(int userId) {

		return null;
	}

	@Override
	public List<Integer> getUsersByAvailability(Availability availability) {
		List<Integer> usersWithSimilarPlayability = new ArrayList<Integer>();
		for (int i = 0; i < playabilityList.size(); i++) {
			if (playabilityList.get(i).getAvailability().equals(availability)
					&& playabilityList.get(i).getStatusIsAvailable() == true) {
				usersWithSimilarPlayability
						.add(playabilityList.get(i).getUserId());
			}
		}
		return usersWithSimilarPlayability;
	}

	public void examplePlayability() {
		playabilityList
				.add(new Playability(1, Availability.AFTERNOON, null, true));
		playabilityList
				.add(new Playability(2, Availability.AFTERNOON, null, true));
		playabilityList
				.add(new Playability(3, Availability.EVENING, null, true));
		playabilityList
				.add(new Playability(4, Availability.MORNING, null, true));
		playabilityList.add(new Playability(5, Availability.AFTERNOON,
				"Moj chomik jest chory, nie moze zostac sam", false));
	}

}
