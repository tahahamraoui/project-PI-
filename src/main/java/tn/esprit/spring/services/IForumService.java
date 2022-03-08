package tn.esprit.spring.services;


import tn.esprit.spring.entity.Forum;

import java.util.List;
import java.util.Set;



public interface IForumService {
	List<Forum> retrieveAllForums();
	Forum addForum(Forum c);
	void deleteForum(Long id);
	Forum updateForum(Forum c);
	Forum retrieveForum(Long id);
	List<Forum> FindOfferBySujet(String sujet);
	List<Object[]> statistic();
}