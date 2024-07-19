package com.example.vogue_vault.services.AddressServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Address;
import com.example.vogue_vault.repositories.AddressRepository;

@Service
public class AddressServicesImpl {
	@Autowired
	AddressRepository obj;
	
	public String addAddress(Address a) {
		obj.save(a);
		return "Address added successfully";
	}
	
	public Iterable<Address> getAllAddress(){
		return obj.findAll();
	}
}
