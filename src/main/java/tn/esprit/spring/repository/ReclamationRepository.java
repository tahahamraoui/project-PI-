package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;




@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Integer>  {

	@Query("SELECT ve, Count(ve) as nbre FROM Reclamation ve GROUP BY ve.TypeReclamation")
	public List<Object> groupReclamations();
	
	@Query("SELECT c.TypeReclamation, COUNT(c.TypeReclamation) FROM Reclamation AS c GROUP BY c.TypeReclamation ORDER BY c.TypeReclamation DESC")
	List<Object[]> countTotalTypeByYear();
}
