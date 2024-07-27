package com.example.vogue_vault.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vogue_vault.RequestClass.AddCartItemRequest;
import com.example.vogue_vault.RequestClass.AddWishlistItemRequest;
import com.example.vogue_vault.entities.Address;
import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.entities.WishList;
import com.example.vogue_vault.services.UsersServices.UsersServicesImpl;

@RestController
public class UsersController {

	@Autowired
	UsersServicesImpl obj;

//	@PostMapping("/users/addUsers")
//	public ResponseEntity<String> addUsers(@RequestBody Users u) {
//	    try {
//	        for (WishList wish : u.getWishList()) {
//	            wish.setUserWishList(u);
//	        }
//	        for (MyCart cart : u.getCartList()) {
//	            cart.setUserCartList(u);
//	        }
//	        obj.addUsers(u);
//	        return ResponseEntity.ok("User added successfully");
//	    } catch (Exception e) {
//	        e.printStackTrace(); // Print stack trace to logs
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
//	    }
//	}
	
	
	@PostMapping("users/createUser")
    public String createUser(@RequestBody Users user) {
		
		if (user.getUserAddress() != null) {
            user.getUserAddress().setUser(user);
        }
        
        if (user.getWishList() != null) {
            user.getWishList().forEach(wishListItem -> wishListItem.setUserWishList(user));
        }
        
        if (user.getCartList() != null) {
            user.getCartList().forEach(cartListItem -> cartListItem.setUserCartList(user));
        }
		
        return obj.createUserWithDetails(user);
    }
	
	
	@PostMapping("/users/updateAddress")
    public String updateUserAddress(@RequestBody Map<String, Object> payload) {
        int userId = (Integer) payload.get("userId");

        Address newAddress = new Address();
        newAddress.setLocality((String) payload.get("locality"));
        newAddress.setStreet((String) payload.get("street"));
        newAddress.setSubLocality((String) payload.get("subLocality"));
        newAddress.setArea((String) payload.get("area"));
        newAddress.setPhone((String) payload.get("phone"));
        newAddress.setCountry((String) payload.get("country"));

        return obj.updateUserAddress(userId, newAddress);
    }
	
	
	@PostMapping("/users/addCartItem")
    public String addCartItem(@RequestBody AddCartItemRequest request) {
        return obj.addCartItem(request.getUserId(), request.getCartItem());
    }

	@PostMapping("/users/addWishlistItem")
	public String addWishlistItem(@RequestBody Map<String, Object> request) {
	    int userId = (int) request.get("userId");
	    Map<String, Object> wishlistItemMap = (Map<String, Object>) request.get("wishlistItem");

	    WishList wishlistItem = new WishList();
	    wishlistItem.setProductId((int) wishlistItemMap.get("productId"));
	    wishlistItem.setProductName((String) wishlistItemMap.get("productName"));
	    wishlistItem.setSmallDesc((String) wishlistItemMap.get("smallDesc"));
	    wishlistItem.setMainDesc((String) wishlistItemMap.get("mainDesc"));
	    wishlistItem.setCategoryName((String) wishlistItemMap.get("categoryName"));
	    wishlistItem.setStock((int) wishlistItemMap.get("stock"));
	    wishlistItem.setImageUrl((String) wishlistItemMap.get("imageUrl"));
	    wishlistItem.setFavorite((boolean) wishlistItemMap.get("favorite"));
	    wishlistItem.setRating((int) wishlistItemMap.get("rating"));
	    wishlistItem.setSizes((List<String>) wishlistItemMap.get("sizes"));
	    wishlistItem.setColors((List<String>) wishlistItemMap.get("colors"));
	    wishlistItem.setPrice((double) wishlistItemMap.get("price"));

	    return obj.addWishlistItem(userId, wishlistItem);
	}



	@PostMapping("/users/getUserByEmail")
	public Users getUserByEmail(@RequestBody String email) {
		return obj.getUserByEmail(email);
	}

	@PostMapping("/users/getUserById")
	public Optional<Users> getUserById(@RequestBody Map<String , Integer> payload) {
		int userId = payload.get("userId");
		return obj.getUserById(userId);
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
	
	@PostMapping("/users/deleteUser")
	public String deleteUser(@RequestBody Map<String,Integer> payload) {
		int userId = payload.get("userId");
		return obj.deleteUser(userId);
	}

}
