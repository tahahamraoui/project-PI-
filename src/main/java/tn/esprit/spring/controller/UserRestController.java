package tn.esprit.spring.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.User;
import tn.esprit.spring.services.IDomaineService;

import tn.esprit.spring.services.IUserService;

@RestController
//@Api(tags = "User management")
@CrossOrigin(origins = "http://localhost:8090")
@RequestMapping("/u")
public class UserRestController {
//injection de service
	@Autowired
	IUserService UserService;
	@Autowired
	IDomaineService DomaineService;
	
	//http://localhost:8090/SpringMVC/u/welcome
	@RequestMapping("/welcome")
	public String welcomepage() {
		return "Welcome to Yawin Tutor";
	}
	
	
	//http://localhost:8090/SpringMVC/u/retrieve-all-Users
		@GetMapping("/retrieve-all-Users")
		@ResponseBody
		//@ApiOperation(value = "Récupérer la liste des Users")
		public List<User> getUsers() {
		List<User> listUsers = UserService.retrieveAllUsers();
		return listUsers;
		}

		//http://localhost:8090/SpringMVC/u/retrieve-User/8
		@GetMapping("/retrieve-User/{User-id}")
		@ResponseBody
		public User retrieveUser(@PathVariable("User-id") Long UserId) {
		return UserService.retrieveUser(UserId);
		}

		//http://localhost:8090/SpringMVC/u/add-User
		@PostMapping("/add-User")
		@ResponseBody
		public User addUser(@RequestBody User c)
		{
			
		User User = UserService.addUser(c);
		return User;
		}
		
		
		//http://localhost:8090/SpringMVC/u/remove-User/5
		@DeleteMapping("/remove-User/{User-id}")
		@ResponseBody
		public void removeForum(@PathVariable("User-id") Long userId) {
			UserService.deleteUser(userId);
		}
		
		
		
		//http://localhost:8090/SpringMVC/u/modify-User
		@PutMapping("/modify-User/{User-id}")
		@ResponseBody
		public User modifyUser(@RequestBody User user) {
		return UserService.updateUser(user);
		}

		
		
	
	
}
