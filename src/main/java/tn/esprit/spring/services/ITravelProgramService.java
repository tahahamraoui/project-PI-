package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;

public interface ITravelProgramService {

	public void addTravelProgram(TravelProgram h);
	public void updateTravelProgram(TravelProgram h);
	public void deleteTravelProgram(Integer  h);
	public List<TravelProgram> afficherTravelProgram();
	public void addHotelToTravelProgram(Integer Hotel ,Integer TravelProgram );
}
