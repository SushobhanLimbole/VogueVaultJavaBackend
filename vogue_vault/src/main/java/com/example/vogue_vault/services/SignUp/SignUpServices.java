package com.example.vogue_vault.services.SignUp;

import java.util.List;

import com.example.vogue_vault.entities.SignUp;

public interface SignUpServices {
	String addSignUp(List<SignUp> l);
	Iterable<SignUp> getAllSignUp();
}
