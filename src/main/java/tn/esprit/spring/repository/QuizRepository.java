package tn.esprit.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Quiz;
import tn.esprit.spring.entity.Reclamation;


@Repository
public interface QuizRepository  extends CrudRepository< Quiz,Integer> {

}
