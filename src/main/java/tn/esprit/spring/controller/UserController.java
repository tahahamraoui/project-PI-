package tn.esprit.spring.controller;

import org.springframework.stereotype.Controller;

import tn.esprit.spring.services.IUserService;

@Controller
public class UserController {
	//injection annotation
		IUserService IUserService;

}
