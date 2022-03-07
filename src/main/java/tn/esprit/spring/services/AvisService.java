package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import tn.esprit.spring.entity.AnalyseAvis;
import tn.esprit.spring.entity.Avis;

import tn.esprit.spring.repository.AvisRepository;

@Service
public class AvisService implements IAvisService {

	@Autowired
	AvisRepository avisRepo;
		
		@Override
		public List<Avis> retrieveAllAvis() {
			List<Avis> av = (List<Avis>) avisRepo.findAll();
			return av;
		}

		@Override
		public Avis addAvis(Avis c) {
			return avisRepo.save(c); 
		}

		@Override
		public String deleteAvis(Integer id) {
			if(avisRepo.findById(id).orElse(null) != null) {
				avisRepo.deleteById(id);
				return "feedback removed successfully!";
			}
			else return "feedback id not found!";
		}

		@Override
		public Avis updateAvis(Avis c) {
			return avisRepo.save(c);
		}

		

		@Override
		public Avis retrieveAvis(int idR) {
			return avisRepo.findById(idR).orElse(null);
		}

		
		public AnalyseAvis analyseAvis(String avis)
		{
			String t = avis.replace(" ", "%20") ;
			System.out.println(t);
			String url2 ="https://textapis.p.rapidapi.com/sentiment?text="+t ;
		    RestTemplate restTemplate = new RestTemplate();
		    HttpHeaders headers=new HttpHeaders();
		    headers.add("x-rapidapi-host", "textapis.p.rapidapi.com");
		    headers.add("x-rapidapi-key", "77870dab2cmsh950e7229bf17507p158e87jsne665edaf9905");
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity=new HttpEntity<String>(headers);
		    return  restTemplate.exchange(url2,HttpMethod.GET,entity,AnalyseAvis.class).getBody();
		
			/*String url2 = "https://text-sentiment.p.rapidapi.com/analyze" ; 
		    RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers=new HttpHeaders();
			headers.add("content-type", "application/x-www-form-urlencoded");
		    headers.add("x-rapidapi-host", "text-sentiment.p.rapidapi.com");
		    headers.add("x-rapidapi-key", "77870dab2cmsh950e7229bf17507p158e87jsne665edaf9905");
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity=new HttpEntity<String>(headers);
		    return  restTemplate.exchange(url2,HttpMethod.GET,entity,AnalyseAvis.class,t).getBody();*/
		}
			
		
		
		@Override
		public List<String> AvisAnalyser() {
			List<String> p = new ArrayList<String>();
			List<Avis> av = (List<Avis>) avisRepo.findAll();
			for(Avis a : av)
			{
				p.add(a.toString() + analyseAvis(a.getDescriptionAvis())); 
			}
			return p ;
		}
}
