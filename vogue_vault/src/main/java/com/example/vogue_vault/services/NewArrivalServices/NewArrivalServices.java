package com.example.vogue_vault.services.NewArrivalServices;

import java.util.List;

import com.example.vogue_vault.entities.NewArrival;

public interface NewArrivalServices {

	String addNewArrivals(List<NewArrival> l);
	Iterable<NewArrival> getAllNewArrivals();
	String deleteAllNewArrivals();
	String deleteNewArrivalItem(int id);
}
