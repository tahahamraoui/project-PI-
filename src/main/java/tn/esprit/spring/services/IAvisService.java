package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.AnalyseAvis;
import tn.esprit.spring.entity.Avis;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.repository.AvisRepository;


public interface IAvisService  {
	public List<Avis> retrieveAllAvis();
	public Avis addAvis(Avis c);
	public String deleteAvis(Integer idAvis);
	public Avis updateAvis(Avis c);
	public Avis retrieveAvis(int idAvis);
	public AnalyseAvis analyseAvis(String avis);
	public List<String> AvisAnalyser();
		

}
