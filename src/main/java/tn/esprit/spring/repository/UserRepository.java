package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.User;
public interface UserRepository extends JpaRepository <User, Long> {


	@Query("SELECT f FROM User f  where f.email = :email")
    public List<User> FindOfferBySujet(@Param("email") String email);


	@Query("SELECT c.datecreated , c.emailVerificationStatus , COUNT(c.datecreated)"
			+ " FROM User AS c "
			+ "GROUP BY c.datecreated  "
			+ "ORDER BY c.datecreated DESC")
	List<Object[]> countTotalTypeByYear();
}
