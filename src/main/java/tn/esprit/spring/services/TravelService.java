package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.TravelAgencyRep;
import tn.esprit.spring.repository.TravelProgramRep;
import tn.esprit.spring.repository.TravelRep;
@Service
public class TravelService implements ITravelService {
@Autowired
TravelRep tR;
@Autowired
TravelAgencyRep taR ; 
@Autowired
TravelProgramRep tpR;
@Autowired
IUserRepository uR ;
	@Override
	public void addTravel(Travel h) {
		// TODO Auto-generated method stub
		tR.save(h);
	}

	@Override
	public void updateTravel(Travel h) {
		// TODO Auto-generated method stub
		tR.save(h);
	}

	@Override
	public void deleteTravel(Integer h) {
		// TODO Auto-generated method stub
		tR.deleteById(h);
	}

	@Override
	public List<Travel> afficherTravel() {
		// TODO Auto-generated method stub
		return (List<Travel>) tR.findAll();
	}

	@Override
	public void addTravelAgencyToTravel(Integer taID, Integer t) {
		// TODO Auto-generated method stub
		Travel t2 = tR.findById(t).orElse(null);
		TravelAgency ta = taR.findById(taID).orElse(null);
		t2.setTa(ta);
		tR.save(t2);
	}

	@Override
	public void addTravelProgramToTravel(Integer tpId , Integer t) {
		// TODO Auto-generated method stub
	Travel t2 = tR.findById(t).orElse(null);
	TravelProgram tp = tpR.findById(tpId).orElse(null);
	t2.setTp(tp);
	tR.save(t2); 
	}

	@Override
	public List<Travel> findTravelsByTravelAgency(Integer travelAgencyID) {
		// TODO Auto-generated method stub
		TravelAgency ta = taR.findById(travelAgencyID).orElse(null);
		return tR.findByTravelAgency(ta); 
	}

	@Override
	public List<Travel> findTravelsByTravelProgram(Integer travelProgramID) {
		// TODO Auto-generated method stub
		TravelProgram tp = tpR.findById(travelProgramID).orElse(null);
		return tR.findByTravelProgram(tp);
	}

	@Override
	public List<Travel> findTravelsByUser(Long UserID) {
		// TODO Auto-generated method stub
		User u = uR.findById(UserID).orElse(null);
		return tR.findTravelsByUser(u);
	}

	@Override
	public void addUserToTravel(Long UserId, Integer t) {
		Travel t2 = tR.findById(t).orElse(null);
		User u = uR.findById(UserId).orElse(null);
		List<User> lu = t2.getUsers();
		lu.add(u);
		t2.setUsers(lu);
		tR.save(t2);
		
	}

}
