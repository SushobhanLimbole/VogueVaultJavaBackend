package com.example.vogue_vault.services.SignUp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.NewArrival;
import com.example.vogue_vault.entities.SignUp;
import com.example.vogue_vault.repositories.SignUpRepository;

@Service
public class SignUpServiceImple implements SignUpServices {
	@Autowired
	SignUpRepository obj;
	
	public String addSignUp(List<SignUp> l) {
		obj.saveAll(l);
		return "User added successfully";
	}
	
	public Iterable<SignUp> getAllSignUp(){
		return obj.findAll();
	}

}
