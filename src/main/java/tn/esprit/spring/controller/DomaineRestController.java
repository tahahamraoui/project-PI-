package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Domaine;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.IDomaineService;
import tn.esprit.spring.services.IUserService;

@RestController
//@Api(tags = "User management")
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/d")
public class DomaineRestController {
	//injection de service
		@Autowired
		IDomaineService DomaineService;
		@Autowired
		IUserService UserService;
		
		
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
				if ((TestVald(c) == false) && (TestValParMot(c.getName_d()).equals("not found")) && TestValParMotDesMots(c.getMots()).equals("not found")){
					domaine = DomaineService.addDomaine(c);
					return  "Domaine added sucessfuly :"+domaine.toString();
				}else if (!TestValParMot(c.getName_d()).equals("not found")){
					return "Domaine already exist ! \n"+TestValParMot(c.getName_d()) ;
				}else 
					return "Domaine already exist ! \n"+TestValParMotDesMots(c.getMots()) ;
			}
			
	
			public boolean TestVald(Domaine c){
				String domaine = DomaineService.GetDomaine(c.getName_d());
				if (domaine == null ){
					return false;
				}
				return true ;
			}
			
				public String TestValParMot(String name){
				//String domaine = DomaineService.findByDomainWord(c.getName_d());
				List<Domaine> d =  getDomaines() ;
				for( Domaine dom : d){
					for (int i=0; i<dom.getMots().size();i++ ){
						if (dom.getMots().get(i).equals(name)){
							return "Domain Name : "+dom.getName_d() ;
						}
						System.out.println("Domain mot "+i+" : "+dom.getMots().get(i));
					}
				}
				return "not found";
			}
				
			
			public String TestValParMotDesMots(ArrayList<String> mots){
					//String domaine = DomaineService.findByDomainWord(c.getName_d());
					List<Domaine> d =  getDomaines() ;
					for( Domaine dom : d){
						for (int i=0; i<dom.getMots().size();i++ ){
							for(int j=0; j<mots.size(); j++){
								
								if (dom.getMots().get(i).equals(mots.get(j))){
									return "Domain Name : "+dom.getName_d() ;
								}
								System.out.println("Domaine mot "+i+" : "+dom.getMots().get(i));
								System.out.println("Domaine mot "+j+" : "+mots.get(j));
							}
						}
					}
					return "not found";
				}
			
			//http://localhost:8090/SpringMVC/d/retrieve-Domaine/8
			@GetMapping("/retrieve-Domaine/{Domaine-id}")
			@ResponseBody
			public Domaine retrieveDomaine(@PathVariable("Domaine-id") Long DomaineId) {
			return DomaineService.retrieveDomaine(DomaineId);
			}
			

			//http://localhost:8090/SpringMVC/d/retrieve-Domaine/8
			@GetMapping("/retrieve-User-Domaine/{Domaine-name}")
			@ResponseBody
			public List<User> retrieveUserDomaine(@PathVariable("Domaine-name") String DomaineName) {
				
				List<User> listUsers = DomaineService.findByDomainUser(DomaineName);
				List<User> listUsers2 = new ArrayList();
				
			     for (User us : listUsers){
			    	 User u = new User() ;
			    	 	u.setUser_id(us.getUser_id());
						u.setName(us.getName());
						u.setEmail(us.getEmail());
						u.setImage(us.getImage());
						listUsers2.add(u);
				}
				
				//return listUsers2.toString();
				 return listUsers2;
			}
}
