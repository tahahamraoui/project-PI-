package tn.esprit.spring.repository;

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
}
