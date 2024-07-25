package com.example.vogue_vault.services.MyCartServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.repositories.MyCartRepository;

@Service
public class MyCartServicesImpl implements MyCartServices{

	@Autowired
	MyCartRepository obj;
	
	public String addToCart(MyCart m) {
		obj.save(m);
		return "Added to cart";
	}
	
	public String addAllCartItems(List<MyCart> l) {
		obj.saveAll(l);
		return "Added All Cart Items";
	}
	
	public Iterable<MyCart> getCartItems(){
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
