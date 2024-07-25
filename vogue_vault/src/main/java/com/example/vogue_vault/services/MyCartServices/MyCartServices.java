package com.example.vogue_vault.services.MyCartServices;

import java.util.List;

import com.example.vogue_vault.entities.MyCart;

public interface MyCartServices {

	String addToCart(MyCart m);
	String addAllCartItems(List<MyCart> l);
	Iterable<MyCart> getCartItems();
	String deleteAllCartItems();
	String deleteCartItem(int id);
}
