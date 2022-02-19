package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.TravelProgram;

@Repository
public interface TravelProgramRep extends CrudRepository<TravelProgram,Integer> {

}
