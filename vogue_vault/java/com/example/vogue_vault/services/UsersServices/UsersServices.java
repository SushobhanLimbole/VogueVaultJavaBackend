package com.example.vogue_vault.services.UsersServices;

import java.util.List;

import com.example.vogue_vault.entities.Bags;
import com.example.vogue_vault.entities.Users;

public interface UsersServices {
	String addUsers(Users u);
	Iterable<Users> getAllUsers();
}
