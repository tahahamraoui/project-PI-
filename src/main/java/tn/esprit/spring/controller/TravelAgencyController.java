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
import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.services.ITravelAgencyService;


@RestController
@Api(tags = "TravelAgency management")
@RequestMapping("/TravelAgency")
@CrossOrigin(origins = "http://localhost:8089")
public class TravelAgencyController {
	@Autowired
	ITravelAgencyService TAS; 
	
	@PostMapping("/add-TravelAgency")
	@ResponseBody
	public void ajouterTravelAgency(@RequestBody TravelAgency h)
	{
		TAS.addTravelAgency(h);
	}

@PutMapping("update-TravelAgency")
@ResponseBody
public void updateTravelAgency(@RequestBody TravelAgency t)
{
	TAS.addTravelAgency(t);
}

@DeleteMapping("/remove-TravelAgency/{TravelAgency-id}")
@ResponseBody
public void removeClient(@PathVariable("TravelAgency-id") Integer TravelAgencyId) {

TAS.deleteTravelAgency(TravelAgencyId);
}

@GetMapping("/afficherTravelAgency")
@ApiOperation(value = "Récupérer la liste des TravelAgencys ")
@ResponseBody
public List<TravelAgency> getTravelAgencys() {
	
return TAS.afficherTravelAgency();

}


}
