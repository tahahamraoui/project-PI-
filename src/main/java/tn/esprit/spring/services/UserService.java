 package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

//import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
//import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.services.IUserService;


@Service
public class UserService implements IUserService {
//injection annotation
	@Autowired
	IUserRepository myRepository;
	
public static final Logger L = LogManager.getLogger(UserService.class);


@Override
public List<User> retrieveAllUsers() {
	List<User> c = (List<User>) myRepository.findAll();
	return c;
}
@Override
public User addUser(User c){
	return myRepository.save(c);
}
@Override
public void deleteUser(Long user_id){
	myRepository.deleteById(user_id);
}
@Override
public User updateUser(User c){
	return myRepository.save(c);
}

@Override
public User retrieveUser(Long user_id){
	Optional<User> c = myRepository.findById(user_id);
	User c1 = c.get();
	return c1;
}


	

}
