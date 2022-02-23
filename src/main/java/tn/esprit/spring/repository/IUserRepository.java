package tn.esprit.spring.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.User;

public interface IUserRepository extends JpaRepository <User, Long>{
	//List <User> findByFirstName (String firstName);
	//List <User> findByLastName (String LastName);
	//List <User> findByIdGreaterThan (int LastName);

}
