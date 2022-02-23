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
import tn.esprit.spring.entity.Hotel;
import tn.esprit.spring.services.HotelService;
@RestController
@Api(tags = "Hotel management")
@RequestMapping("/Hotel")
@CrossOrigin(origins = "http://localhost:8089")
public class HotelController {
	@Autowired
	HotelService HS; 
	
	@PostMapping("/add-Hotel")
	@ResponseBody
	public void ajouterHotel(@RequestBody Hotel h)
	{
		HS.addHotel(h);
	}

@PutMapping("update-Hotel")
@ResponseBody
public void updateHotel(@RequestBody Hotel h)
{
	HS.addHotel(h);
}

@DeleteMapping("/remove-Hotel/{hotel-id}")
@ResponseBody
public void removeClient(@PathVariable("hotel-id") Integer hotelId) {

HS.deleteHotel(hotelId);
}

@GetMapping("/afficherHotel")
@ApiOperation(value = "Récupérer la liste des hotels ")
@ResponseBody
public List<Hotel> getHotels() {
	
return HS.afficherHotels();

}


}
