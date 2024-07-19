package com.example.vogue_vault.services.WishListServices;

import com.example.vogue_vault.entities.WishList;

public interface WishListServices {
	String addToWishList(WishList w);

	Iterable<WishList> getWishListItems();

	String deleteAllWishListItems();

	String deleteWishListItem(int id);
}
