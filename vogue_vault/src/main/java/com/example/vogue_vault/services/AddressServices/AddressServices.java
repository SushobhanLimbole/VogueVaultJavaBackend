package com.example.vogue_vault.services.AddressServices;

import com.example.vogue_vault.entities.Address;

public interface AddressServices {
	String addAddress(Address a);
	Iterable<Address> getAllAddress();
}
