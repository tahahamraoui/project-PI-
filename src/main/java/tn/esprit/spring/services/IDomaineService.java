package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entity.Domaine;
import tn.esprit.spring.entity.User;

public interface IDomaineService {

	List<Domaine> retrieveAllDomaines();

	Domaine addDomaine(Domaine d);
	
	Domaine GetDomaine(String d); 

	//List<Domaine> retrieveAllDomaines(Optional<String> sortBy);

}
