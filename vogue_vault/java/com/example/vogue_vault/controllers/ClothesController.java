package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Clothes;
import com.example.vogue_vault.services.ClothesServices.ClothesServicesImpl;

@RestController
public class ClothesController {

	@Autowired
	ClothesServicesImpl obj;
	
	@PostMapping("/clothes/addAllClothes")
	public String addAllClothes(@RequestBody List<Clothes> l) {
		return obj.addAllClothes(l);
	}
	
	@GetMapping("/clothes/getAllClothes")
	public Iterable<Clothes> getAllClothes(){
		return obj.getAllClothes();
	}
	
	@DeleteMapping("/clothes/deleteAllClothes")
	public String deleteAllClothes() {
		return deleteAllClothes();
	}
	
	@DeleteMapping("/clothes/deleteClothes/{id}")
	public String deleteClothes(@PathVariable int id) {
		return deleteClothes(id);
	}
}
