package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entity.Domaine;
import tn.esprit.spring.entity.User;

public interface IDomaineService {

	List<Domaine> retrieveAllDomaines();

	Domaine addDomaine(Domaine d);
	
	String GetDomaine(String d); 
	
	Domaine updateDomaine(Domaine d);

	Domaine retrieveDomaine(Long id_d);

	List<User> findByDomainUser(String domaineName);
	
	String findByDomainWord(String mot);

	

	//List<Domaine> retrieveAllDomaines(Optional<String> sortBy);

}
