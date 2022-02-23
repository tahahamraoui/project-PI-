package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Hotel;
import tn.esprit.spring.entity.TravelProgram;

public interface IHotelService {
	
	public void addHotel(Hotel h);
	public void updateHotel(Hotel h);
	public void deleteHotel(Integer h);
	public List<Hotel> afficherHotels();
	
	

}
