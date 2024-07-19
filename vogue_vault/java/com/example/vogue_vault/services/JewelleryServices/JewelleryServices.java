package com.example.vogue_vault.services.JewelleryServices;

import java.util.List;

import com.example.vogue_vault.entities.Jewellery;

public interface JewelleryServices {

	String addAllJewellery(List<Jewellery> l);
	Iterable<Jewellery> getAllJewellery();
	String deleteAllJewellery();
	String deleteJewellery(int id);
}
