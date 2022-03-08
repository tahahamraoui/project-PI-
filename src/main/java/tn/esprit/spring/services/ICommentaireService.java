package tn.esprit.spring.services;


import tn.esprit.spring.entity.Commentaire;

import tn.esprit.spring.entity.Forum;

import java.io.IOException;
import java.util.List;
import java.util.Set;



public interface ICommentaireService {
	List<Commentaire> retrieveAllCommentaires();
	Commentaire addCommentaire(Commentaire c , long idf);
	
	void deleteCommentaire(Long id);
	Commentaire updateCommentaire(Commentaire c);
	Commentaire retrieveCommentaire(Long id);
	Commentaire addCommentaire(Commentaire f, Long idForum);

}
