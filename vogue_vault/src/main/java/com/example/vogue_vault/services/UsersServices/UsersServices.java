package com.example.vogue_vault.services.UsersServices;

import java.util.Optional;

import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.entities.WishList;

public interface UsersServices {
	String addUsers(Users u);
	String addCartItem(int userId, MyCart cartItem);
	String addWishlistItem(int userId, WishList wishlistItem);
	Users getUserByEmail(String email);
	Optional<Users> getUserById(int id);
	Iterable<Users> getAllUsers();
	String deleteCartItem(int userId, int cartId);
	String deleteWishListItem(int userId, int wishListId);
	String updateCartQty(int userId, int cartId, int newQty);
}
