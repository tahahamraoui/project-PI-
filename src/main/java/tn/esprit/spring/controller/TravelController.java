package tn.esprit.spring.controller;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.News;
import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Value;
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



@GetMapping("/findTravelsByID/{id}")
@ApiOperation(value = "findTravelsByID ")
@ResponseBody
public Travel findTravelsByID(@PathVariable("id")Integer id ) {
	
return TS.findTravelsByID(id);

}
@GetMapping("/findTravelPartner/{UserID}/{travelID}")
@ApiOperation(value = "findTravelPartner ")
@ResponseBody
public HashSet<User> findTravelPartner(@PathVariable("UserID") Long UserID , @PathVariable("travelID") Integer travelID )
{
	return TS.findTravelPartner(UserID, travelID);
}


@PutMapping("/discountTravelAgency/{TravelAgency-id}")
@ApiOperation(value = "discountTravelAgency ")
@ResponseBody
public Long Discount(@PathVariable("TravelAgency-id")Integer idTravelAgency)
{
	return TS.Discount(idTravelAgency);
}

@GetMapping("/blockDestination")
@ApiOperation(value = "block destination ")
@ResponseBody
public String blockDestination( )
{
	//InetSocketAddress host = headers.getHost();
   
    /*
	response.addHeader("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com");
    
    response.addHeader("x-rapidapi-key", "77870dab2cmsh950e7229bf17507p158e87jsne665edaf9905");
    System.out.println(response.get);*/
	//.asString();
	/*final String uri = "http://localhost:8080/springrestexample/employees.xml";

    
    restTemplate.execute(url, POST , requestCallback, responseExtractor)
    String result = restTemplate.getForObject(uri, String.class);*/
	/* String url2 ="https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/search/TrendingNewsAPI?pageNumber=1&pageSize=10&withThumbnails=false&location=us";
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers=new HttpHeaders();
    headers.add("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com");
    headers.add("x-rapidapi-key", "77870dab2cmsh950e7229bf17507p158e87jsne665edaf9905");
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity=new HttpEntity<String>(headers);
    return restTemplate.exchange(url2,HttpMethod.GET,entity,String.class).getBody();*/
	return TS.blockDestination(); 
}
}
