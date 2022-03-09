package tn.esprit.spring.services;
import java.util.List;

import tn.esprit.spring.entity.Invitation;



public interface IInvitationService {
	List<Invitation> retrieveAllInvitations();
	Invitation addInvitation(Invitation c);
	void deleteInvitation(int id);
	Invitation updateInvitation(Invitation c);
	Invitation retrieveInvitation(int id);
	List<Integer> sendInvitations(List<String> to);
	boolean acceptInvitation(Integer id);
	boolean consulterAcceptation(Integer id);

}