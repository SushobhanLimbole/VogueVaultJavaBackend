package com.example.vogue_vault.services.ElectronicsServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Electronics;
import com.example.vogue_vault.repositories.ElectronicsRepository;

@Service
public class ElectronicsServicesImpl implements ElectronicsServices{

	@Autowired
	ElectronicsRepository obj;
	
	public String addAllElectronics(List<Electronics> l) {
		obj.saveAll(l);
		return "Added all electronics successfully";
	}
	
	public String addElectronics(Electronics e) {
		obj.save(e);
		return "Added electronics successfully";
	}
	
	public Iterable<Electronics> getAllElectronics(){
		System.out.println("get ele called");
		return obj.findAll();
	}
	
	public String deleteAllElectronics() {
		obj.deleteAll();
		return "Deleted all items";
	}
	
	public String deleteElectronicItem(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
