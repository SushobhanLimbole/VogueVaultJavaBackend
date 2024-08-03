package com.example.vogue_vault.services.UsersServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vogue_vault.entities.Address;
import com.example.vogue_vault.entities.MyCart;
import com.example.vogue_vault.entities.Users;
import com.example.vogue_vault.entities.WishList;
import com.example.vogue_vault.repositories.AddressRepository;
import com.example.vogue_vault.repositories.UsersRepository;
import com.example.vogue_vault.services.MyCartServices.MyCartServicesImpl;
import com.example.vogue_vault.services.WishListServices.WishListServicesImpl;

import jakarta.transaction.Transactional;

@Service
public class UsersServicesImpl implements UsersServices {

	@Autowired
	UsersRepository usersRepo;
	
	@Autowired
	AddressRepository addressRepo;

	@Autowired
	MyCartServicesImpl cartServices;

	@Autowired
	WishListServicesImpl wishListServices;

	public String addUsers(Users u) {
		usersRepo.save(u);
		return "User added successfully";
	}
	
	@Override
	public String createUserWithDetails(Users user) {
		usersRepo.save(user);
		return "User Created successfully";
	}
	
	public String updateUserAddress(int userId, Address newAddress) {
        Users user = usersRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        if (user.getUserAddress() != null) {
            newAddress.setAddressId(user.getUserAddress().getAddressId());
        }

        newAddress.setUser(user);
        user.setUserAddress(newAddress);
        
        addressRepo.save(newAddress);
        usersRepo.save(user);
        return "Address updated successfully";
    }

	public Users getUserByEmail(String email) {
		for (Users u : usersRepo.findAll()) {
			if (email.contentEquals(u.getUserEmail())) {
				return u;
			}
		}
		return null;
	}
	
	
	@Override
    public String addCartItem(int userId, MyCart cartItem) {
        Optional<Users> userOptional = usersRepo.findById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            cartItem.setUserCartList(user); // Ensure the relationship is set
            user.getCartList().add(cartItem);
            usersRepo.save(user);
            return "Cart item added successfully";
        }
        return "User not found";
    }

	@Override
	public String addWishlistItem(int userId, WishList wishlistItem) {
	    Optional<Users> userOptional = usersRepo.findById(userId);
	    if (userOptional.isPresent()) {
	        Users user = userOptional.get();
	        
	        // Check if the product is already in the wishlist
	        for (WishList item : user.getWishList()) {
	            if (item.getProductId() == wishlistItem.getProductId() && item.getCategoryName().contentEquals(wishlistItem.getCategoryName())) {
	                return "Wishlist item already exists";
	            }
	        }

	        // If not present, add the new wishlist item
	        wishlistItem.setUserWishList(user); // Ensure the relationship is set
	        user.getWishList().add(wishlistItem);
	        usersRepo.save(user);
	        return "Wishlist item added successfully";
	    }
	    return "User not found";
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
	public String deleteWishListItem(int userId, int productId, String categoryName) {
	    Optional<Users> userOptional = usersRepo.findById(userId);
	    if (userOptional.isPresent()) {
	        Users user = userOptional.get();
	        List<WishList> wishList = user.getWishList();

	        WishList itemToRemove = wishList.stream()
	            .filter(wish -> wish.getProductId() == productId && wish.getCategoryName().equals(categoryName))
	            .findFirst()
	            .orElse(null);

	        if (itemToRemove != null) {
	            wishList.remove(itemToRemove);
	            wishListServices.deleteWishListItem(itemToRemove.getId()); 
	            user.setWishList(wishList); 
	            usersRepo.save(user); 
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

	public String deleteUser(int userId) {
		usersRepo.deleteById(userId);
		return "User deleted successfully";
	}
}
