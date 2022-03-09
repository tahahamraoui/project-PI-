package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;




@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Integer>  {

	@Query("SELECT ve, Count(ve) as nbre FROM Reclamation ve GROUP BY ve.TypeReclamation")
	public List<Object> groupReclamations();
	
	@Query("SELECT c.TypeReclamation, COUNT(c.TypeReclamation) FROM Reclamation "
			+ "AS c GROUP BY c.TypeReclamation "
			+ "ORDER BY c.TypeReclamation DESC")
	List<Object[]> countTotalTypeByYear();
	
	@Query("SELECT f FROM Reclamation f WHERE f.TypeReclamation LIKE %?1%" )//to search
           // + " OR f.date LIKE %?1%")
           // + " OR f.Domain LIKE %?1%")
            //+ " OR CONCAT(p.price, '') LIKE %?1%")
    public List<Reclamation> search(String TypeReclamation);
	
	
	
	@Query("SELECT f FROM Reclamation f  where f.TypeReclamation = :TypeReclamation")
    public List<Reclamation> FindReclamationByTypeReclamation(@Param("TypeReclamation") String TypeReclamation);

	
}
