package com.example.vogue_vault.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.vogue_vault.entities.MyCart;


public interface MyCartRepository extends CrudRepository<MyCart, Integer>{

}
