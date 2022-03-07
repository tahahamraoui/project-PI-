package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.TravelProgram;

@Repository
public interface TravelProgramRep extends CrudRepository<TravelProgram,Integer> {
	/*@Query("SELECT f FROM Offer f  where f.Title = :Title")
    public List<Offer> FindOfferByTitle(@Param("Title") String title);*/
}
