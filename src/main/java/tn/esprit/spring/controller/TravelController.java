package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Travel;

import tn.esprit.spring.services.TravelService;

@RestController
@Api(tags = "Travel management")
@RequestMapping("/Travel")
@CrossOrigin(origins = "http://localhost:8089")
public class TravelController {
	
	@Autowired
	TravelService TS; 
	
	@PostMapping("/add-Travel")
	@ResponseBody
	public void ajouterTravel(@RequestBody Travel h)
	{
		TS.addTravel(h);
	}

@PutMapping("update-Travel")
@ResponseBody
public void updateTravel(@RequestBody Travel t)
{
	TS.addTravel(t);
}

@DeleteMapping("/remove-Travel/{Travel-id}")
@ResponseBody
public void removeClient(@PathVariable("Travel-id") Integer TravelId) {

TS.deleteTravel(TravelId);
}

@GetMapping("/afficherTravel")
@ApiOperation(value = "Récupérer la liste des Travels ")
@ResponseBody
public List<Travel> getTravels() {
	
return TS.afficherTravel();

}


@PostMapping("/addTravelProgramToTravel/{TravelProgram-id}/{Travel-id}")
@ApiOperation(value = "AddTravelProgramToTravel ")
@ResponseBody
public void addTravelProgramToTravel(@PathVariable("TravelProgram-id")Integer idTravelProgram, @PathVariable("Travel-id") Integer idTravel) {
	
	
	TS.addTravelProgramToTravel(idTravelProgram, idTravel);
}

@PostMapping("/addTravelAgencyToTravel/{TravelAgency-id}/{Travel-id}")
@ApiOperation(value = "addTravelAgencyToTravel ")
@ResponseBody
public void addTravelAgencyToTravel(@PathVariable("TravelAgency-id")Integer idTravelAgency, @PathVariable("Travel-id") Integer idTravel) {
	
	
	TS.addTravelAgencyToTravel(idTravelAgency, idTravel);
}


@PostMapping("/addUserToTravel/{User-id}/{Travel-id}")
@ApiOperation(value = "addUserToTravel ")
@ResponseBody
public void addUserToTravel(@PathVariable("User-id")Long idUser, @PathVariable("Travel-id") Integer idTravel) {
	
	
	TS.addUserToTravel(idUser, idTravel);
}
 
@GetMapping("/findTravelsByTravelAgency/{TravelAgency-id}")
@ApiOperation(value = "findTravelsByTravelAgency ")
@ResponseBody
public List<Travel> findTravelsByTravelAgency(@PathVariable("TravelAgency-id")Integer idTravelAgency ) {
	
return TS.findTravelsByTravelAgency(idTravelAgency); 

}

@GetMapping("/findTravelsByTravelProgram/{TravelProgram-id}")
@ApiOperation(value = "findTravelsByTravelProgram ")
@ResponseBody
public List<Travel> findTravelsByTravelProgram(@PathVariable("TravelProgram-id")Integer idTravelProgram ) {
	
return TS.findTravelsByTravelAgency(idTravelProgram); 

}


@GetMapping("/findTravelsByUser/{User-id}")
@ApiOperation(value = "findTravelsByUser ")
@ResponseBody
public List<Travel> findTravelsByUser(@PathVariable("User-id")Long idUser ) {
	
return TS.findTravelsByUser(idUser); 

}
}
