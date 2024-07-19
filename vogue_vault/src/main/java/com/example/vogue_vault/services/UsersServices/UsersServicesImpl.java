package com.example.vogue_vault.services.UsersServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.repositories.UsersRepository;

@Service
public  class UsersServicesImpl implements UsersServices{

	@Autowired
	UsersRepository obj;
	
	public String addUsers(Users u) {
		obj.save(u);
		return "User added successfully";
	}

	public Iterable<Users> getAllUsers() {
		return obj.findAll();
	}
}
