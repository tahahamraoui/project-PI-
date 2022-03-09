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
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.services.ITravelProgramService;

@RestController
@Api(tags = "TravelProgram management")
@RequestMapping("/TravelProgram")
@CrossOrigin(origins = "http://localhost:8089")
public class TravelProgramController {
	@Autowired
	ITravelProgramService TPS; 
	
	@PostMapping("/add-TravelProgram")
	@ResponseBody
	public void ajouterTravelProgram(@RequestBody TravelProgram h)
	{
		TPS.addTravelProgram(h);
	}

@PutMapping("update-TravelProgram")
@ResponseBody
public void updateTravelProgram(@RequestBody TravelProgram t)
{
	TPS.addTravelProgram(t);
}

@DeleteMapping("/remove-TravelProgram/{TravelProgram-id}")
@ResponseBody
public void removeClient(@PathVariable("TravelProgram-id") Integer TravelProgramId) {

TPS.deleteTravelProgram(TravelProgramId);
}

@GetMapping("/afficherTravelProgram")
@ApiOperation(value = "Récupérer la liste des TravelPrograms ")
@ResponseBody
public List<TravelProgram> getTravelPrograms() {
	
return TPS.afficherTravelProgram();

}

@PostMapping("/addHotelToTravelProgram/{Hotel-id}/{TravelProgram-id}")
@ApiOperation(value = "addHotelToTravelProgram ")
@ResponseBody
public void addHotelToTravelProgram(@PathVariable("Hotel-id")Integer idHotel, @PathVariable("TravelProgram-id") Integer idTravelProgram) {
	
	
	TPS.addHotelToTravelProgram(idHotel, idTravelProgram);
}
 
}
