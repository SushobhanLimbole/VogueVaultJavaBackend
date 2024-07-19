package com.example.vogue_vault.services.NewArrivalServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.NewArrival;
import com.example.vogue_vault.repositories.NewArrivalRepository;

@Service
public class NewArrivalServicesImpl implements NewArrivalServices{

	@Autowired
	NewArrivalRepository obj;
	
	public String addNewArrivals(List<NewArrival> l) {
		obj.saveAll(l);
		return "Added all new arrivals";
	}
	
	public Iterable<NewArrival> getAllNewArrivals(){
		return obj.findAll();
	}
	
	public String deleteAllNewArrivals() {
		obj.deleteAll();
		return "Deleted all items";
	}
	
	public String deleteNewArrivalItem(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
