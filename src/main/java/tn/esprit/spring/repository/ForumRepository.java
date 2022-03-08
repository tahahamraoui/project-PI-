package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Forum;

@Repository
public interface ForumRepository  extends JpaRepository<Forum, Long>{
	
	@Query("SELECT f FROM Forum f  where f.sujet = :sujet")
    public List<Forum> FindOfferBySujet(@Param("sujet") String sujet);
	
	
	@Query("SELECT c.sujet, COUNT(c.sujet)"
			+ " FROM Forum AS c "
			+ "GROUP BY c.sujet "
			+ "ORDER BY c.sujet DESC")
	List<Object[]> countTotalTypeByYear();

}