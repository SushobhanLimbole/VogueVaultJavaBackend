package com.example.vogue_vault.CartServices;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.vogue_vault.entities.Cart;
import com.example.vogue_vault.entities.MyCart;

public interface CartServices {
	
	String addToCart(Cart m);
	Iterable<Cart> getCartItems();
	String deleteAllCartItems();
	String deleteCartItem(int id);
}


