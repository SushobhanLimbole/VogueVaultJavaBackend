package com.example.vogue_vault.RequestClass;

import com.example.vogue_vault.entities.MyCart;

public class AddCartItemRequest {

	private int userId;
	private MyCart cartItem;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MyCart getCartItem() {
		return cartItem;
	}

	public void setCartItem(MyCart cartItem) {
		this.cartItem = cartItem;
	}

}
