package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import tn.esprit.spring.entity.Invitation;

import tn.esprit.spring.services.IInvitationService;
import tn.esprit.spring.services.InvitationService;
@RestController
@Api(tags = "Invitation management")
@RequestMapping("/Invitation")
@CrossOrigin(origins = "http://localhost:8089")
public class InvitationController {
	@Autowired
	IInvitationService InvitationService;

	//http://localhost:8089/SpringMVC/Invitation/retrieve-all-Invitations
	@GetMapping("/retrieve-all-Invitations")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des Invitations")
	public List<Invitation> getInvitations() {
	List<Invitation> listInvitations = InvitationService.retrieveAllInvitations();
	return listInvitations;
	}

	//http://localhost:8089/SpringMVC/Invitation/retrieve-Invitation/8
	@GetMapping("/retrieve-Invitation/{Invitation-id}")
	@ResponseBody
	public Invitation retrieveInvitation(@PathVariable("Invitation-id") int InvitationId) {
	return InvitationService.retrieveInvitation(InvitationId);
	}

	
	//http://localhost:8089/SpringMVC/Invitation/add-Invitation
		@PostMapping("/add-Invitation")
		@ResponseBody
		public Invitation addInvitation(@RequestBody Invitation c)
		{
			Invitation Invitations = InvitationService.addInvitation(c);
		return Invitations;
		}
	
	
	
	//http://localhost:8089/SpringMVC/Invitation/remove-Invitation/{Invitation-id}
	@DeleteMapping("/remove-Invitation/{Invitation-id}")
	@ResponseBody
	public void removeInvitation(@PathVariable("Invitation-id") int InvitationsId) {
	InvitationService.deleteInvitation(InvitationsId);
	}

	//http://localhost:8089/SpringMVC/Invitation/modify-Invitation
	@PutMapping("/modify-Invitation")
	@ResponseBody
	public Invitation modifyInvitation(@RequestBody Invitation Invitation) {
	return InvitationService.updateInvitation(Invitation);
	}

}
