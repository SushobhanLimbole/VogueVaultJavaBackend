package com.example.vogue_vault.services.ElectronicsServices;

import java.util.List;

import com.example.vogue_vault.entities.Electronics;

public interface ElectronicsServices {

	String addAllElectronics(List<Electronics> l);
	Iterable<Electronics> getAllElectronics();
	String deleteAllElectronics();
	String deleteElectronicItem(int id);
}
