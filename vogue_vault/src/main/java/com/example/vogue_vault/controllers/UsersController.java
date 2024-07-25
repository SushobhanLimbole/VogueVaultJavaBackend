package com.example.vogue_vault.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.entities.WishList;
import com.example.vogue_vault.services.UsersServices.UsersServicesImpl;

@RestController
public class UsersController {

	@Autowired
	UsersServicesImpl obj;

	@PostMapping("/users/addUsers")
	public ResponseEntity<String> addUsers(@RequestBody Users u) {
	    try {
	        for (WishList wish : u.getWishList()) {
	            wish.setUserWishList(u);
	        }
	        for (MyCart cart : u.getCartList()) {
	            cart.setUserCartList(u);
	        }
	        obj.addUsers(u);
	        return ResponseEntity.ok("User added successfully");
	    } catch (Exception e) {
	        e.printStackTrace(); // Print stack trace to logs
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
	    }
	}


	@PostMapping("/users/getUserByEmail")
	public Users getUserByEmail(@RequestBody String email) {
		return obj.getUserByEmail(email);
	}

	@PostMapping("/users/getUserById")
	public Optional<Users> getUserById(@RequestBody int id) {
		return obj.getUserById(id);
	}

	@GetMapping("/users/getAllUsers")
	public Iterable<Users> getAllUsers() {
		return obj.getAllUsers();
	}

	@PostMapping("/users/deleteCartItem")
	public String deleteCartItem(@RequestBody Map<String, Integer> payload) {
		int userId = payload.get("userId");
		int cartId = payload.get("cartId");
		return obj.deleteCartItem(userId, cartId);
	}

	@PostMapping("/users/deleteWishListItem")
	public String deleteWishListItem(@RequestBody Map<String, Integer> payload) {
		return obj.deleteWishListItem(payload.get("userId"), payload.get("wishListId"));
	}

	@PostMapping("/users/updateCartQty")
	public String updateCartQty(@RequestBody Map<String, Integer> payload) {
		int userId = payload.get("userId");
		int cartId = payload.get("cartId");
		int newQty = payload.get("newQty");
		return obj.updateCartQty(userId, cartId, newQty);
	}

}
