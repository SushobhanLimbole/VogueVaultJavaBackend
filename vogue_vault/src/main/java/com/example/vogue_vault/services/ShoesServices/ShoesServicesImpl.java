package com.example.vogue_vault.services.ShoesServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Shoes;
import com.example.vogue_vault.repositories.ShoesRepository;

@Service
public class ShoesServicesImpl implements ShoesServices{

	@Autowired
	ShoesRepository obj;
	
	public String addAllShoes(List<Shoes> l) {
		obj.saveAll(l);
		return "Added all shoes successfully";
	}
	
	public String addShoe(Shoes s) {
		obj.save(s);
		return "Added shoe successfully";
	}
	
	public Iterable<Shoes> getAllShoes(){
		return obj.findAll();
	}
	
	public String deleteAllShoes() {
		obj.deleteAll();
		return "Deleted all items";
	}
	
	public String deleteShoe(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
