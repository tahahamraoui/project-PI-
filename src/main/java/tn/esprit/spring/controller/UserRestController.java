package tn.esprit.spring.controller;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import tn.esprit.spring.entity.User;
//import tn.esprit.spring.services.IUserService;

@RestController
public class UserRestController {
	//@Autowired
	//IUserService IUSerService;
	
	/*
	//affichage
	//http://localhost:8090/springMVC/servlet/retrieve-al-users
	@GetMapping(value="/retrieve-al-users")
	@ResponseBody
	public List<User> getUsers(){
		List<User> list = IUSerService.retrieveAllUser();
		return list;
	}
	*/
	@RequestMapping("/welcome")
	public String welcomepage() {
		return "Hello its Rawend ";
	}

}
