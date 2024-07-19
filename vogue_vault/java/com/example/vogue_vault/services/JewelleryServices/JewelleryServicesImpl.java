package com.example.vogue_vault.services.JewelleryServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Jewellery;
import com.example.vogue_vault.repositories.JewelleryRepository;

@Service
public class JewelleryServicesImpl implements JewelleryServices{

	@Autowired
	JewelleryRepository obj;
	
	public String addAllJewellery(List<Jewellery> l) {
		obj.saveAll(l);
		return "Added all jewellery successfully";
	}
	
	public Iterable<Jewellery> getAllJewellery(){
		return obj.findAll();
	}
	
	public String deleteAllJewellery() {
		obj.deleteAll();
		return "Deleted all items";
	}
	
	public String deleteJewellery(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
