package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Shoes;
import com.example.vogue_vault.services.ShoesServices.ShoesServicesImpl;

@RestController
public class ShoesController {

	@Autowired
	ShoesServicesImpl obj;
	
	@PostMapping("/shoes/addAllShoes")
	public String addAllShoes(@RequestBody List<Shoes> l) {
		return obj.addAllShoes(l);
	}
	
	@GetMapping("/shoes/getAllShoes")
	public Iterable<Shoes> getAllShoes(){
		return obj.getAllShoes();
	}
	
	@DeleteMapping("/shoes/deleteAllShoes")
	public String deleteAllShoes() {
		return deleteAllShoes();
	}
	
	@DeleteMapping("/shoes/deleteShoe/{id}")
	public String deleteShoe(@PathVariable int id) {
		return deleteShoe(id);
	}
}
