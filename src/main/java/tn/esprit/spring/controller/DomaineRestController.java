package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Domaine;

import tn.esprit.spring.services.IDomaineService;

@RestController
//@Api(tags = "User management")
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/d")
public class DomaineRestController {
	//injection de service
		@Autowired
		IDomaineService DomaineService;
		
		
		//http://localhost:8090/SpringMVC/d/welcome
		@RequestMapping("/welcome")
		public String welcomepage() {
			return "Welcome to Yawin Tutor";
		}
		
		
		//http://localhost:8090/SpringMVC/d/retrieve-all-Domaines
			@GetMapping("/retrieve-all-Domaines")
			@ResponseBody
			public List<Domaine> getDomaines() {
			List<Domaine> listDomaines = DomaineService.retrieveAllDomaines();
			return listDomaines;
			}
			//http://localhost:8090/SpringMVC/d/add-Domaine
			@PostMapping("/add-Domaine")
			@ResponseBody
			public String addDomaine(@RequestBody Domaine c)
			{
				Domaine domaine;
				//if (TestVald(c) == false ){
					domaine = DomaineService.addDomaine(c);
					return  "Domaine added sucessfuly :"+domaine.toString();
			//	}
			///	return "Domaine already exist !";
			}	
			
			//http://localhost:8090/SpringMVC/d/add-Domaine
			@PostMapping("/test")
			@ResponseBody
			public Domaine TestVald(@RequestBody Domaine c){
				//System.out.println("!!!!!!!!!!!!!!!    "+d.getName_d());
				Domaine domaine = DomaineService.GetDomaine(c.getName_d());
				System.out.println("!!!!!!!!!!!!!!!    "+domaine.toString());
				return domaine ;
				
				/*if (domaine != null ){
					return false;
				}
				return true ;*/
				
			}
}
