package com.example.vogue_vault.RequestClass;

import com.example.vogue_vault.entities.WishList;

public class AddWishlistItemRequest {

	private int userId;
	private WishList wishlistItem;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public WishList getWishlistItem() {
		return wishlistItem;
	}

	public void setWishlistItem(WishList wishlistItem) {
		this.wishlistItem = wishlistItem;
	}

}
