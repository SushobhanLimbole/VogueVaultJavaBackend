package com.example.vogue_vault.services.WishListServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.WishList;
import com.example.vogue_vault.repositories.WishListRepositroy;

@Service
public class WishListServicesImpl {

	@Autowired
	WishListRepositroy obj;
	
	public String addToWishList(WishList w) {
		obj.save(w);
		return "Added to wishList";
	}
	
	public Iterable<WishList> getWishListItems(){
		return obj.findAll();
	}
	
	public String deleteAllWishListItems() {
		obj.deleteAll();
		return "Deleted all items";
	}
	
	public String deleteWishListItem(int id) {
		obj.deleteById(id);
		return "Deleted the item";
	}
}
