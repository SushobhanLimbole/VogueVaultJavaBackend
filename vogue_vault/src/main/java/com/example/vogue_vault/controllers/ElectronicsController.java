package com.example.vogue_vault.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.Electronics;
import com.example.vogue_vault.services.ElectronicsServices.ElectronicsServicesImpl;

@RestController
public class ElectronicsController {

	@Autowired
	ElectronicsServicesImpl obj;
	
	@PostMapping("/electronics/addAllElectronics")
	public String addAllElectronics(@RequestBody List<Electronics> l) {
		return obj.addAllElectronics(l);
	}
	
	@PostMapping("/electronics/addElectronics")
	public String addElectronics(@RequestBody Electronics e) {
		return obj.addElectronics(e);
	}
	
	@GetMapping("/electronics/getAllElectronics")
	public Iterable<Electronics> getAllElectronics(){
		return obj.getAllElectronics();
	}
	
	@DeleteMapping("/electronics/deleteAllElectronics")
	public String deleteAllElectronics() {
		return deleteAllElectronics();
	}
	
	@DeleteMapping("/electronics/deleteElectronicItem/{id}")
	public String deleteElectronicItem(@PathVariable int id) {
		return deleteElectronicItem(id);
	}
}
