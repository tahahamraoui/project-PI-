package tn.esprit.spring.services;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import tn.esprit.spring.entity.User;
public interface  IUserService {
	
	List<User> retrieveAllUsers();
	User addUser(User c) throws UnsupportedEncodingException, MessagingException;
	void deleteUser(Long id);
	User updateUser(User c);
	User retrieveUser(Long id);
	boolean verifyEmailToken(Long id); 
}
