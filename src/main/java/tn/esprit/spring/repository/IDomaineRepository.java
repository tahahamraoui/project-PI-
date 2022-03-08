package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entity.Domaine;

public interface IDomaineRepository extends JpaRepository <Domaine, Long>{
	
	@Query("select d from Domaine d where d.name_d =:nomd")
	Domaine findByDomainName2(@Param("nomd") String nomd);
	
	@Query("select u from Domaine u where u.name_d = ?1")
	Domaine findByDomainName(String emailAddress);
	
	
}
