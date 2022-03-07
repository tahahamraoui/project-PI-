package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.TravelAgency;


@Repository
public interface TravelAgencyRep extends CrudRepository <TravelAgency,Integer> {

}
