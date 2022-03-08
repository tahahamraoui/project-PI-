package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Domaine;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IDomaineRepository;

@Service
public class DomaineService implements IDomaineService{
	//injection annotation
		@Autowired
		IDomaineRepository myRepository;
		
		public static final Logger L = LogManager.getLogger(UserService.class);
		
		
		@Override
		public List<Domaine> retrieveAllDomaines() {
			List<Domaine> d = (List<Domaine>) myRepository.findAll();
			return d;
		}
		
		@Override
		public Domaine addDomaine(Domaine d){
			return myRepository.save(d);
		}
		
		//*******
		@Override
		public String GetDomaine(String d){	
			return myRepository.findByDomainName(d);	
		}
		//*******
		
		@Override
		public Domaine updateDomaine(Domaine d){
			return myRepository.save(d);
		}
		
		@Override
		public Domaine retrieveDomaine(Long id_d){
			Optional<Domaine> d = myRepository.findById(id_d);
			Domaine d1 = d.get();
			return d1;
		}

		@Override
		public List<User> findByDomainUser(String domaineName) {
			List<User> u = myRepository.findByDomainUser(domaineName);
			return u;
		}
		
		@Override
		public String findByDomainWord(String mot) {
			return myRepository.findByDomainMot(mot);
			 
		}

	

}
