package tn.esprit.spring.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.Forum;
import tn.esprit.spring.repository.CommentaireRepository;
import tn.esprit.spring.repository.ForumRepository;


@Service
public class CommentaireService implements ICommentaireService {
	
	@Autowired
	CommentaireRepository myRepository ;
	
	@Autowired
	ForumRepository myRepositoryClient ;
	
	@Override
	public List<Commentaire> retrieveAllCommentaires() {
		   List<Commentaire> c = (List<Commentaire>) myRepository.findAll();
		return c;
	}
	
@Override
public Commentaire addCommentaire(Commentaire c , long idf){
	
	List<String> content = new ArrayList<String>();
	BufferedReader reader;
	String line = null ;
	
	try {
		reader = new BufferedReader(new FileReader("C:/Users/tahat/Documents/GitHub/project-PIdiv/src/test/java/tn/esprit/spring/bad_word.txt"));
		line = reader.readLine();
		while ( line != null){
			if (c.getDescription().contains(line)){
				content.add(line);
				System.out.println("you are using bad words");
				System.out.println(content);
			}
			// read next line 
			line = reader.readLine();
		}
		reader.close();
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	if (content.size() > 0 ){
		return null ;
		
	}
	else {
		Forum p=myRepositoryClient.findById(idf).orElse(null);
		Commentaire C=myRepository.save(c);
		
		C.setDateCreated(LocalDateTime.now());
		C.setForum(p);
		return myRepository.save(C); 
	}
	}
	
@Override
public void deleteCommentaire(Long id){
		myRepository.deleteById(id);
	}

@Override
public Commentaire updateCommentaire(Commentaire c){
		//c.setDateCreated(LocalDateTime.now());
		return myRepository.save(c);
	}
	
@Override
public Commentaire retrieveCommentaire(Long id){
		Commentaire c = myRepository.findById(id).orElse(null);
		return c;
		
	}

@Override
public Commentaire addCommentaire(Commentaire f, Long idForum ){
	
		Optional<Forum> c = myRepositoryClient.findById(idForum);
		Forum c1 = c.get();
		f.setForum(c1);
		return myRepository.save(f);
	
	}
}
	
