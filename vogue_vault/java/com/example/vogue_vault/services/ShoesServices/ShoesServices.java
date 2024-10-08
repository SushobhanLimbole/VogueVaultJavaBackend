package com.example.vogue_vault.services.ShoesServices;

import java.util.List;

import com.example.vogue_vault.entities.Shoes;

public interface ShoesServices {

	String addAllShoes(List<Shoes> l);
	Iterable<Shoes> getAllShoes();
	String deleteAllShoes();
	String deleteShoe(int id);
}
