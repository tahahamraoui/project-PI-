package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Hotel;
@Repository
public interface HotelRep extends CrudRepository<Hotel,Integer> {

}
