package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Invitation;
import tn.esprit.spring.repository.InvitationRepository;

@Service
public class InvitationService implements IInvitationService {
	 @Autowired
	 InvitationRepository myRepository ;
	
	 @Override
	 public List<Invitation> retrieveAllInvitations() {
		 List<Invitation> c = (List<Invitation>) myRepository.findAll();
		 return c;
	 }
	 @Override
	 public Invitation addInvitation(Invitation c){
		 return myRepository.save(c);
	 }
	 @Override
	 public void deleteInvitation(int id){
		 myRepository.deleteById(id);
	 }
	 @Override
	 public Invitation updateInvitation(Invitation c){
		 return myRepository.save(c);
	 }
	
	 @Override
	 public Invitation retrieveInvitation(int id){
			Optional<Invitation> c = myRepository.findById(id);
			Invitation c1 = c.get();
			return c1;
	}
	
	
	
}
