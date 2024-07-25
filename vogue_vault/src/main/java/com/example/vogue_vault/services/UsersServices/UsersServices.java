package com.example.vogue_vault.services.UsersServices;

import java.util.Optional;

import com.example.vogue_vault.entities.Users;

public interface UsersServices {
	String addUsers(Users u);
	Users getUserByEmail(String email);
	Optional<Users> getUserById(int id);
	Iterable<Users> getAllUsers();
	String deleteCartItem(int userId, int cartId);
	String deleteWishListItem(int userId, int wishListId);
	String updateCartQty(int userId, int cartId, int newQty);
}
