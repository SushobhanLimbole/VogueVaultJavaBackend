package com.example.vogue_vault.CartServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Cart;
import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.repositories.CartRepository;

@Service
public class CartServicesImpl implements CartServices{
	
	@Autowired
	CartRepository obj;
	
	public String addToCart(Cart m) {
		obj.save(m);
		return "Added to cart";
	}
	
	public Iterable<Cart> getCartItems(){
		return obj.findAll();
	}
	
	public String deleteAllCartItems() {
		obj.deleteAll();
		return "Deleted all items";
	}
	
	public String deleteCartItem(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
