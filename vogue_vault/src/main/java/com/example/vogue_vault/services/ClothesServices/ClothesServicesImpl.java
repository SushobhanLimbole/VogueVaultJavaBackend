package com.example.vogue_vault.services.ClothesServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Clothes;
import com.example.vogue_vault.repositories.ClothesRepository;

@Service
public class ClothesServicesImpl implements ClothesServices{

	@Autowired
	ClothesRepository obj;
	
	public String addAllClothes(List<Clothes> l) {
		obj.saveAll(l);
		return "Added all clothes successfully";
	}
	
	public String addCloth(Clothes c) {
		obj.save(c);
		return "Added cloth successfully";
	}
	
	public Iterable<Clothes> getAllClothes(){
		return obj.findAll();
	}
	
	public String deleteAllClothes() {
		obj.deleteAll();
		return "Deleted all clothes";
	}
	
	public String deleteClothes(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
