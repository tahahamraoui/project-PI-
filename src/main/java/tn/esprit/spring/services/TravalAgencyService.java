package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.repository.TravelAgencyRep;

@Service
public class TravalAgencyService implements ITravelAgencyService {
	@Autowired
	TravelAgencyRep taR; 
	@Override
	public void addTravelAgency(TravelAgency h) {
		// TODO Auto-generated method stub
		taR.save(h);
	}

	@Override
	public void updateTravelAgency(TravelAgency h) {
		// TODO Auto-generated method stub
		taR.save(h);
	}

	@Override
	public void deleteTravelAgency(Integer h) {
		// TODO Auto-generated method stub
		taR.deleteById(h);
	}

	@Override
	public List<TravelAgency> afficherTravelAgency() {
		// TODO Auto-generated method stub
		return (List<TravelAgency>) taR.findAll();
	}

}
