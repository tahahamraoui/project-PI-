package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Domaine;
import tn.esprit.spring.entity.User;

public interface IDomaineRepository extends JpaRepository <Domaine, Long>{
	
	
	@Query("select d.name_d from Domaine d where d.name_d = :name_d")
	  String findByDomainName(@Param("name_d") String name_d);
	
	@Query("select user from Domaine d where d.name_d = :name_d")
	  List<User> findByDomainUser(@Param("name_d") String name_d);
	
	@Query("select d.name_d from Domaine d where d.mots LIKE %:mot% ")
	  String findByDomainMot(@Param("mot") String mot);
	 
}