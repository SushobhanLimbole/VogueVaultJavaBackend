package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.NewArrival;
import com.example.vogue_vault.services.NewArrivalServices.NewArrivalServicesImpl;

@RestController
public class NewArrivalController {

	@Autowired
	NewArrivalServicesImpl obj;
	
	@PostMapping("/newArrival/addNewArrivals")
	public String addNewArrivals(@RequestBody List<NewArrival> l) {
		return obj.addNewArrivals(l);
	}
	
	@GetMapping("/newArrival/getAllNewArrivals")
	public Iterable<NewArrival> getAllNewArrivals(){
		return obj.getAllNewArrivals();
	}
	
	@DeleteMapping("/newArrival/deleteAllNewArrivals")
	public String deleteAllNewArrivals() {
		return deleteAllNewArrivals();
	}
	
	@DeleteMapping("/newArrival/deleteNewArrivalItem/{id}")
	public String deleteNewArrivalItem(@PathVariable int id) {
		return deleteNewArrivalItem(id);
	}
}
