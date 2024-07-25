package com.example.vogue_vault.services.UsersServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.entities.WishList;
import com.example.vogue_vault.repositories.UsersRepository;
import com.example.vogue_vault.services.MyCartServices.MyCartServicesImpl;
import com.example.vogue_vault.services.WishListServices.WishListServicesImpl;

@Service
public class UsersServicesImpl implements UsersServices {

	@Autowired
	UsersRepository usersRepo;

	@Autowired
	MyCartServicesImpl cartServices;

	@Autowired
	WishListServicesImpl wishListServices;

	public String addUsers(Users u) {
		usersRepo.save(u);
		return "User added successfully";
	}

	public Users getUserByEmail(String email) {
		for (Users u : usersRepo.findAll()) {
			if (email.contentEquals(u.getUserEmail())) {
				return u;
			}
		}
		return null;
	}

	public Optional<Users> getUserById(int id) {
		Optional<Users> user = usersRepo.findById(id);
		return user;
	}

	public Iterable<Users> getAllUsers() {
		return usersRepo.findAll();
	}

	@Override
	public String deleteCartItem(int userId, int cartId) {
		Optional<Users> userOptional = usersRepo.findById(userId);
		if (userOptional.isPresent()) {
			Users user = userOptional.get();
			List<MyCart> cartList = user.getCartList();
			boolean removed = cartList.removeIf(cart -> cart.getId() == cartId);
			if (removed) {
				cartServices.deleteCartItem(cartId); // Delete cart item from MyCartRepository
				user.setCartList(cartList); // Update the user's cart list
				usersRepo.save(user); // Save the updated user
				return "Cart item deleted successfully";
			}
			return "Cart item not found";
		}
		return "User not found";
	}

	@Override
	public String deleteWishListItem(int userId, int wishListId) {
		Optional<Users> userOptional = usersRepo.findById(userId);
		if (userOptional.isPresent()) {
			Users user = userOptional.get();
			List<WishList> wishList = user.getWishList();
			boolean removed = wishList.removeIf(wish -> wish.getId() == wishListId);
			if (removed) {
				wishListServices.deleteWishListItem(wishListId); // Delete wishlist item from WishListRepository
				user.setWishList(wishList); // Update the user's wishlist
				usersRepo.save(user); // Save the updated user
				return "Wishlist item deleted successfully";
			}
			return "Wishlist item not found";
		}
		return "User not found";
	}
	
	@Override
	public String updateCartQty(int userId, int cartId, int newQty) {
	    Optional<Users> userOptional = usersRepo.findById(userId);
	    if (userOptional.isPresent()) {
	        Users user = userOptional.get();
	        List<MyCart> cartList = user.getCartList();
	        for (MyCart cart : cartList) {
	            if (cart.getId() == cartId) {
	                cart.setCartQty(newQty);
	                usersRepo.save(user);
	                return "Cart quantity updated successfully";
	            }
	        }
	        return "Cart item not found";
	    }
	    return "User not found";
	}

}
