package tn.esprit.spring.services;

import java.util.HashSet;
import java.util.List;

import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.entity.User;


public interface ITravelService {
	public void addTravel(Travel h);
	public void updateTravel(Travel h);
	public void deleteTravel(Integer h);
	
	public List<Travel> afficherTravel();
	public void addTravelProgramToTravel(Integer travelProgramId , Integer t);
	public void addTravelAgencyToTravel(Integer travelAgencyId ,Integer t ); 
	public void addUserToTravel(Long UserId ,Integer t ); 
	public Travel findTravelsByID(Integer travelAgencyID);
	public List<Travel> findTravelsByTravelAgency(Integer travelAgencyID);
	public List<Travel> findTravelsByTravelProgram(Integer travelProgramID);
	public List<Travel> findTravelsByUser(Long UserID);
	
	public HashSet<User> findTravelPartner(Long UserID , Integer travelID);
}
