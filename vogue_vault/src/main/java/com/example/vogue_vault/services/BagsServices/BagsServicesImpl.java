package com.example.vogue_vault.services.BagsServices;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Bags;
import com.example.vogue_vault.repositories.BagsRepository;

@Service
public class BagsServicesImpl implements BagsServices{

	@Autowired
	BagsRepository obj;
	
	public String addBag(Bags b) {
		obj.save(b);
		return "Bag added successfully";
	}
	
	public Iterable<Bags> getAllBags(){
		return obj.findAll();
	}
	
	public String addAllBags(List<Bags> l) {
		obj.saveAll(l);
		return "All Bags added successfully";
	}
	
	public String deleteAllBags() {
		obj.deleteAll();
		return "Deleted all bags";
	}
	
	public String deleteBag(int id) {
		obj.deleteById(id);
		return "Deleted the bag";
	}
}
