package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entity.Reclamation;

public interface IReclamationService {
	Reclamation addReclamation(Reclamation c);
	String deleteReclamation(Integer idQ);
	Reclamation updateidReclamation(Reclamation c);
	Reclamation retrieveidReclamation(int idQ);
}
