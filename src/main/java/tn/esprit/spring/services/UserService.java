package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.services.UserService;

@Service
public class UserService {
	//injection annotation
		@Autowired
		IUserRepository IUserRepository;
		
		public static final Logger L = LogManager.getLogger(UserService.class);
		
		/*
		@Override
		public List<User> retrieveAllUser(){
			List<User> users = (List<User>) IUserRepository.findAll();
			  for (User user : users){
				  L.info("user : " +user.toString());
			  }
			return users;
		}
		*/
		
		public User createUser(User user){
			return IUserRepository.save(user);
		}
		
		public List<User> createUsers(List<User> users){
			return IUserRepository.saveAll(users);
		}
		
		public User getUserById(int user_id){
			return IUserRepository.findById((long) user_id).orElse(null);
		}
		
		public List<User>getUsers(){
			return IUserRepository.findAll();
		}
		
		public User updateUser(User user){
			Optional<User> optionaluser=IUserRepository.findById(user.getUser_id());
			if(optionaluser.isPresent()){
				User oldUser=optionaluser.get();
				oldUser.setUser_firstName(user_firstName);
				oldUser.setUser_lastName(user_LastName);
				oldUser.setUser_email(user_email);
				oldUser.setUser_password(user_password);
				
				
				
				
			}
			return user;
		} 

}
