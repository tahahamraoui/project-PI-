package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.entity.User;
@RestController
@Api(tags = "User management")
@RequestMapping("/User")
@CrossOrigin(origins = "http://localhost:8089")
public class UserController {
	@Autowired
	IUserService UserService;

	//http://localhost:8089/SpringMVC/user/retrieve-all-Users
	@GetMapping("/retrieve-all-Users")
	@ResponseBody
	@ApiOperation(value = "Récupérer la liste des Users")
	public List<User> getUsers() {
	List<User> listUsers = UserService.retrieveAllUsers();
	return listUsers;
	}

	//http://localhost:8089/SpringMVC/User/retrieve-User/8
	@GetMapping("/retrieve-User/{User-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("User-id") Long UserId) {
	return UserService.retrieveUser(UserId);
	}

	//http://localhost:8089/SpringMVC/User/add-User
	@PostMapping("/add-User")
	@ResponseBody
	public User addUser(@RequestBody User c) throws UnsupportedEncodingException, MessagingException
	{
	User User = UserService.addUser(c);
	
	
	return User;
	}
	
	
	//http://localhost:8089/SpringMVC/User/remove-User/{User-id}
	@DeleteMapping("/remove-User/{User-id}")
	@ResponseBody
	public void removeForum(@PathVariable("User-id") Long userId) {
		UserService.deleteUser(userId);
	}
	
	
	
	//http://localhost:8089/SpringMVC/User/modify-User
	@PutMapping("/modify-User")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return UserService.updateUser(user);
	}

	@GetMapping(path="/email-verification")

	public boolean verifyEmailToken(@RequestParam(value="id") Long id) {
		return UserService.verifyEmailToken(id);
	}
	
	//URL : //http://localhost:8089/SpringMVC/User/afficherPDF/{user_Id}
	@GetMapping(value = "/afficherPDF/{user_Id}")
	public void userpdf (@PathVariable("user_Id") int id) {
		UserService.userpdf(id);
	}
	
	
	
	//http://localhost:8089/SpringMVC/User/FindOfferBySujet
	@GetMapping("/FindOfferBySujet/{email}")
	@ResponseBody
	public List<User> FindOfferBySujet(@PathVariable String email) 
	{
		return  UserService.FindOfferBySujet(email);
	}
	
	
	//http://localhost:8089/SpringMVC/User/getTypeuserStat
	@GetMapping("/getTypeuserStat")
	public  List<Object[]> statistic() {
		return UserService.statistic();
	}
	
}
