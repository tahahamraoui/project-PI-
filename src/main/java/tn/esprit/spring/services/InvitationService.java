package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Invitation;
import tn.esprit.spring.repository.InvitationRepository;
import tn.esprit.spring.services.SendEmailService;

@Service
public class InvitationService implements IInvitationService {
	 @Autowired
	 InvitationRepository myRepository ;
	 
	 @Autowired
	 SendEmailService sendemailservice ;
	
	 @Override
	 public List<Invitation> retrieveAllInvitations() {
		 List<Invitation> c = (List<Invitation>) myRepository.findAll();
		 return c;
	 }
	 @Override
	 public Invitation addInvitation(Invitation c){
		 c.setStatutenvoie(false);
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
	 @Override
	 public List<Integer> sendInvitations(List<String> to) {
		 String[] toArray = new String [to.size()];
		 List<Integer> ids = new ArrayList<Integer> ();
		 int i = 0 ;
		 for(String email : to ) {
			 Date today = new Date();
			 Invitation invitation = new Invitation(
					 today,
					 "Invitation",
					 "veuillez Accepter l'invitation",
					 true,
					 false,
					 email);
			 invitation = myRepository.save(invitation);
			 ids.add(invitation.getIdinvitation());
			 toArray[i] = email;
			 i++;
		 }
		 sendemailservice.sendEmail(toArray, "noreply@invitation.com", "Veuillez Accepter l'invitation","Invitation");
		 return ids;
	 }
	 
	@Override
	public boolean acceptInvitation(Integer id) {
		Invitation invitation = myRepository.findById(id).get();
		invitation.setStatusacceptation(true);
		myRepository.save(invitation);
		return true;
	}
	
	@Override
	public boolean consulterAcceptation(Integer id) {
		Invitation invitation = myRepository.findById(id).get();
		return invitation.isStatusacceptation();
	}
	
	
	
}
