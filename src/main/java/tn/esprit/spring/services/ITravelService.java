package tn.esprit.spring.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.News;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Value;


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
	
	Long Discount(Integer travelAgency );
	public String blockDestination(); 
	//public void block();
	public void block(String destination2);
	
	public  List<Object[]> statistic  (); 

}
