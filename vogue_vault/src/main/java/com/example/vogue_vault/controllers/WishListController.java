package com.example.vogue_vault.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.entities.WishList;
import com.example.vogue_vault.services.MyCartServices.MyCartServicesImpl;
import com.example.vogue_vault.services.WishListServices.WishListServicesImpl;

@RestController
public class WishListController {

	@Autowired
	WishListServicesImpl obj;

	@PostMapping("/wishlist/addToWishList")
	public String addToWishList(@RequestBody WishList w) {
		return obj.addToWishList(w);
	}

	@GetMapping("/wishlist/getWishListItems")
	public Iterable<WishList> getWishListItems() {
		return obj.getWishListItems();
	}

	@DeleteMapping("/myCart/deleteAllWishListItems")
	public String deleteAllWishListItems() {
		return obj.deleteAllWishListItems();
	}

	@PostMapping("/myCart/deleteWishListItem")
	public String deleteWishListItem(@RequestBody int id) {
		return obj.deleteWishListItem(id);
	}
}
