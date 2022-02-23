package tn.esprit.spring.services;


import java.util.List;

import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;

public interface ITravelAgencyService {

	public void addTravelAgency(TravelAgency h);
	public void updateTravelAgency(TravelAgency h);
	public void deleteTravelAgency(Integer h);
	public List<TravelAgency> afficherTravelAgency();
	
}
