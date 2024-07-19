package com.example.vogue_vault.services.BagsServices;

import java.util.List;

import com.example.vogue_vault.entities.Bags;

public interface BagsServices {

	String addBag(Bags b);
	String addAllBags(List<Bags> l);
	Iterable<Bags> getAllBags();
	String deleteAllBags();
	String deleteBag(int id);
}
