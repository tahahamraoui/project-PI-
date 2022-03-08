package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Hotel;
import tn.esprit.spring.repository.HotelRep;

@Service
public class HotelService implements IHotelService {
	@Autowired
	HotelRep hR ;
	@Override
	public void addHotel(Hotel h) {
		// TODO Auto-generated method stub
		hR.save(h);
	}

	@Override
	public void updateHotel(Hotel h) {
		// TODO Auto-generated method stub
		hR.save(h);
	}

	@Override
	public void deleteHotel(Integer hotelId) {
		// TODO Auto-generated method stub
		hR.deleteById(hotelId);
	}

	@Override
	public List<Hotel> afficherHotels() {
		// TODO Auto-generated method stub
		return (List<Hotel>) hR.findAll();
	}
	
	

}
