package com.acostajp.controller;


import com.acostajp.model.Cart;
import com.acostajp.model.Category;
import com.acostajp.model.ChangeQuantityRequest;
import com.acostajp.model.Product;
import com.acostajp.repository.ICartRepository;
import com.acostajp.service.CartService;
import com.acostajp.service.ProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class DemoControllerCart {

	 
	 
	@Autowired
	 private CartService cartService;
	 
	 
	 

    @PostMapping
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {
    	
        return ResponseEntity.ok(cartService.save(cart));
    }



	    @GetMapping("/{idUser}/carts")
	    public ResponseEntity<List<Cart>>getUserById(@PathVariable Long idUser) {
	    	
			 return ResponseEntity.ok(cartService.findCartByOwner(idUser));
	    }
	 
	 
	    @GetMapping("/checkProductInCart/{idUser}/{idProduct}")
	    public ResponseEntity<Map<String, Boolean>> checkProductInCart(
	        @PathVariable long idUser,
	        @PathVariable long idProduct) {

	        boolean isProductInCart = cartService.checkProductInCart(idUser, idProduct);

	        Map<String, Boolean> response = new HashMap<>();
	        response.put("isProductInCart", isProductInCart);

	        return ResponseEntity.ok(response);
	    }

	   
	    @PostMapping("/changeQuantity")
	    public ResponseEntity<Cart> changeQuantity(@RequestBody Cart cart) {
	        return ResponseEntity.ok(cartService.changeQuantity(cart, cart.getTotalQuantity()));
	    }

		  
	    

   

}

