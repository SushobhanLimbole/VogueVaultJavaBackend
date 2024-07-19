package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Bags;
import com.example.vogue_vault.services.BagsServices.BagsServicesImpl;

@RestController
public class BagsController {

	@Autowired
	BagsServicesImpl obj;
	
	@PostMapping("/bags/addBag")
	public String addBag(@RequestBody Bags b) {
		return obj.addBag(b);
	}
	
	@PostMapping("/bags/addAllBags")
	public String addAllBags(@RequestBody List<Bags> l) {
		return obj.addAllBags(l);
	}
	
	@GetMapping("/bags/getAllBags")
	public Iterable<Bags> getAllBags(){
		return obj.getAllBags();
	}
	
	@DeleteMapping("/bags/deleteAllBags")
	public String deleteAllBags() {
		return deleteAllBags();
	}
	
	@DeleteMapping("/bags/deleteBag/{id}")
	public String deleteBag(@PathVariable int id) {
		return deleteBag(id);
	}
	
}
