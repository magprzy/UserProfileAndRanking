package com.capgemini.userProfileAndRanking.dao;

import java.util.List;

import com.capgemini.userProfileAndRanking.Availability;
import com.capgemini.userProfileAndRanking.entities.Playability;

public interface PlayabilityDao {

	
	public List<Playability> getAllPlayailities(); 
	
	public void addPlayability(Playability playability);
	
	
	
	public Playability getUserPlayability(int userId);
	
	public List<Integer> getUsersByAvailability(Availability availability);
	
	
	
	
}
