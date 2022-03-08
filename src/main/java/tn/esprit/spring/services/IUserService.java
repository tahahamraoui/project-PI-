package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.User;




public interface IUserService {

	List<User> retrieveAllUsers();

	User addUser(User c);

	void deleteUser(Long user_id);

	User updateUser(User c);

	User retrieveUser(Long user_id);

	


		
			
	

}
 