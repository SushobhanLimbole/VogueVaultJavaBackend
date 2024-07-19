package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Jewellery;
import com.example.vogue_vault.services.JewelleryServices.JewelleryServicesImpl;

@RestController
public class JewelleryController {

	@Autowired
	JewelleryServicesImpl obj;
	
	@PostMapping("/jewellery/addAllJewellery")
	public String addAllJewellery(@RequestBody List<Jewellery> l) {
		return addAllJewellery(l);
	}
	
	@GetMapping("/jewellery/getAllJewellery")
	public Iterable<Jewellery> getAllJewellery(){
		return obj.getAllJewellery();
	}
	
	@DeleteMapping("/jewellery/deleteAllJewellery")
	public String deleteAllJewellery() {
		return deleteAllJewellery();
	}
	
	@DeleteMapping("/jewellery/deleteJewellery/{id}")
	public String deleteJewellery(@PathVariable int id) {
		return deleteJewellery(id);
	}
}
