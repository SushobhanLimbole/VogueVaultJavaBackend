package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Address;
import com.example.vogue_vault.services.AddressServices.AddressServicesImpl;

@RestController
public class AddressController {

	@Autowired
	AddressServicesImpl obj;
	
	@PostMapping("/address/addAddress")
	public String addAddress(@RequestBody Address a) {
		return obj.addAddress(a);
	}
	
	@GetMapping("/address/getAllAddress")
	public Iterable<Address> getAllAddress(){
		return obj.getAllAddress();
	}
}
