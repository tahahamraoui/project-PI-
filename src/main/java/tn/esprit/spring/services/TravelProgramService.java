package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Hotel;
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.repository.HotelRep;
import tn.esprit.spring.repository.TravelProgramRep;

@Service
public class TravelProgramService implements ITravelProgramService {
	@Autowired
	TravelProgramRep tpR; 
	
	@Autowired
	HotelRep HR ; 
	@Override
	public void addTravelProgram(TravelProgram h) {
		// TODO Auto-generated method stub
		tpR.save(h);
		
	}

	@Override
	public void updateTravelProgram(TravelProgram h) {
		// TODO Auto-generated method stub
		tpR.save(h);
	}

	@Override
	public void deleteTravelProgram(Integer h) {
		// TODO Auto-generated method stub
		tpR.deleteById(h);
	}

	@Override
	public List<TravelProgram> afficherTravelProgram() {
		// TODO Auto-generated method stub
		return (List<TravelProgram>) tpR.findAll();
	}

	@Override
	public void addHotelToTravelProgram(Integer Hotel, Integer TravelProgram) {
		// TODO Auto-generated method stub
		Hotel h = HR.findById(Hotel).orElse(null);
		TravelProgram pR = tpR.findById(TravelProgram).orElse(null);
		pR.setHotel(h);
		tpR.save(pR);
	}

}
