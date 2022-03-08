package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reponse;
import tn.esprit.spring.repository.ReponseRepository;

@Service
public class ReponseService implements IReponseService {

		@Autowired
		ReponseRepository ReponseRepo;
		
		@Override
		public List<Reponse> retrieveAllReponse() {
			List<Reponse> av = (List<Reponse>) ReponseRepo.findAll();
			return av;
		}

		/*@Override
		 public ArrayList<Reponse> getReponseList() {
		    	for(Reponse l :retrieveAllReponse()) {
		    		try {
		    			String bg = l.getText().replaceAll("good","*****");
		    			System.out.println(bg);
		    			l.setText(bg);
		    		}catch(NullPointerException e) {
		    			
		    		}
		    	
		    	}
		        return (ArrayList<Reponse>)retrieveAllReponse();
		    }*/
		
		@Override
		public Reponse addReponse(Reponse c) {
			return ReponseRepo.save(c); 
		}

		@Override
		public String deleteReponse(Integer id) {
			if(ReponseRepo.findById(id).orElse(null) != null) {
				ReponseRepo.deleteById(id);
				return "Reponse removed successfully!";
			}
			else return "Reponse id not found!";
		}

		@Override
		public Reponse updateidReponse(Reponse c) {
			return ReponseRepo.save(c);
		}

		

		@Override
		public Reponse retrieveidReponse(int idR) {
			return ReponseRepo.findById(idR).orElse(null);
		}

		@Override
		public ArrayList<Reponse> getReponseList() {
			// TODO Auto-generated method stub
			return null;
		}
 

	
}
