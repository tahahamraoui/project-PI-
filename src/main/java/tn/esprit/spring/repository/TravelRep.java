package tn.esprit.spring.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Travel;
import tn.esprit.spring.entity.TravelAgency;
import tn.esprit.spring.entity.TravelProgram;
import tn.esprit.spring.entity.User;


@Repository
public interface TravelRep extends CrudRepository <Travel,Integer>{
	@Query("SELECT t FROM Travel t WHERE t.ta = :travelAgency ")
	List<Travel> findByTravelAgency(@Param("travelAgency") TravelAgency travelAgency);
	
	@Query("SELECT t FROM Travel t WHERE t.tp = :travelProgram ")
	List<Travel> findByTravelProgram(@Param("travelProgram") TravelProgram travelProgram);
	
	@Query("Select t FROM Travel t join t.users bs where bs = :user")
	List<Travel> findTravelsByUser(@Param("user") User user);
	@Query("Select t FROM Travel t join t.users bs where bs.domaine.name_d = :domain2 AND t.StartDate = :StartDate2 AND t.destination = :destination2 ")
	List<Travel> findTravelPartner(@Param("domain2") String domain2 , @Param("StartDate2") LocalDate StartDate2 , @Param("destination2") String destination2);

	//@Query("SELECT COUNT(t) FROM Travel t WHERE t.ta = :travelAgency AND t.StartDate BETWEEN :date1 AND :date2")
	@Query("SELECT t FROM Travel t WHERE t.ta = :travelAgency AND t.StartDate BETWEEN :date2 AND :date1")
	List<Travel> findByTravelAgencyInMonthAgo(@Param("travelAgency") TravelAgency travelAgency ,  @Param("date1") LocalDate date1 , @Param("date2") LocalDate date2);
	@Query("Select t FROM Travel t WHERE t.destination = :destination2 ")
	List<Travel> block ( @Param("destination2") String destination2);
/*@Query("SELECT f FROM Offer f WHERE f.Title LIKE %?1%" //to search
    + " OR f.Place LIKE %?1%"
    + " OR f.Domain LIKE %?1%")
    //+ " OR CONCAT(p.price, '') LIKE %?1%")
public List<Offer> search(String keyword)*/
	
	@Query("SELECT u.domaine.name_d , t.destination FROM Travel t JOIN t.users u GROUP BY u.domaine.name_d ORDER BY u.domaine.name_d DESC")
	List<Object[]> countDestinationByDomainUser();
}

