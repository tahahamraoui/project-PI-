package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Question;

@Repository
public interface QuestionRepository  extends CrudRepository< Question,Integer>  {
	@Query("SELECT ve, Count(v.Text) as Nbre FROM Reponse v JOIN v.question ve GROUP BY ve.Text")
	public List<Object[]> NumberReponsesGroupedByQuestions();
	
}
