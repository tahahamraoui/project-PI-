package tn.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Avis;

@Repository
public interface AvisRepository extends CrudRepository<Avis, Integer>{


	
}
