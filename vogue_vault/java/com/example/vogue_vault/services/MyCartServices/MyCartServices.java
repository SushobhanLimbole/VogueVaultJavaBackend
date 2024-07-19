package com.example.vogue_vault.services.MyCartServices;

import com.example.vogue_vault.entities.MyCart;

public interface MyCartServices {

	String addToCart(MyCart m);
	Iterable<MyCart> getCartItems();
	String deleteAllCartItems();
	String deleteCartItem(int id);
}
