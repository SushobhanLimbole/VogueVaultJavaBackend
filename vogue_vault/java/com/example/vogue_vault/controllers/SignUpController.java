package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.NewArrival;
import com.example.vogue_vault.entities.SignUp;
import com.example.vogue_vault.services.SignUp.SignUpServiceImple;

@RestController
public class SignUpController {
	@Autowired
	SignUpServiceImple obj;
	
	@PostMapping("/SignUp/addSignUp")
	public String addSignUp(@RequestBody List<SignUp> l) {
		return obj.addSignUp(l);
	}
	
	@GetMapping("/SignUp/getAllSignUp")
	public Iterable<SignUp> getAllSignUp(){
		return obj.getAllSignUp();
	}

}
