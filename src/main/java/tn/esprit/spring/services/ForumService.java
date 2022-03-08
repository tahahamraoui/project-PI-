package tn.esprit.spring.services;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Forum;
import tn.esprit.spring.repository.ForumRepository;


@Service
public class ForumService implements IForumService {
	
	@Autowired
	ForumRepository myRepository ;
	
	@Override
	public List<Forum> retrieveAllForums() {
		List<Forum> c = (List<Forum>) myRepository.findAll();
	   	return c;
		//return (List<Forum>) myRepository.findAll();
	}
	@Override
	public Forum addForum(Forum c){
		c.setDatecreated(LocalDateTime.now());
		return myRepository.save(c);
	}
	@Override
	public void deleteForum(Long id){
		myRepository.deleteById(id);
	}
	@Override
	public Forum updateForum(Forum c){
		c.setDatecreated(LocalDateTime.now());
	
		return myRepository.save(c);
	}
	
	@Override
	public Forum retrieveForum(Long id){
			return myRepository.findById(id).orElse(null);
		
	}
	
	@Override
	 public List<Forum> FindOfferBySujet(String sujet) {
		 return myRepository.FindOfferBySujet(sujet);
	}
	
	@Override
	public  List<Object[]> statistic() {
		return myRepository.countTotalTypeByYear();
	}
}