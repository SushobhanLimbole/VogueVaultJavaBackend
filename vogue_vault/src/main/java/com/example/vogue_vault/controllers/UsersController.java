package com.example.vogue_vault.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.services.UsersServices.UsersServicesImpl;

@RestController
public class UsersController {

	@Autowired
	UsersServicesImpl obj;
	
	@PostMapping("/users/addUsers")
	public String addUsers(@RequestBody Users u) {
		return obj.addUsers(u);
	}
	
	@GetMapping("/users/getAllUsers")
	public Iterable<Users> getAllUsers(){
		return obj.getAllUsers();
	}
}
