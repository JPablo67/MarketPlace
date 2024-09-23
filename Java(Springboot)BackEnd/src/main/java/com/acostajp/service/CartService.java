package com.acostajp.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acostajp.model.Cart;
import com.acostajp.model.Product;
import com.acostajp.model.Sale;
import com.acostajp.model.User;
import com.acostajp.repository.ICartRepository;
import com.acostajp.repository.ISaleRepository;



@Service
public class CartService {

	@Autowired
	 private ICartRepository cartRepository;
	
		
	
	 
	
	public List<Cart> findCartByOwner(long idUser){
		 User user = new User();
		 user.setIdUser(idUser);
		 List<Cart> listaDeCarritos =  cartRepository.findByUser(user);
		 return listaDeCarritos;
	    
	 }
	
	
	
	
	
	public Cart save(Cart cart) {
		
		boolean productInCar = checkProductInCart(cart.getUser().getIdUser(), cart.getProduct().getIdProduct());
		
		
		
		if(!productInCar==true ) {
			
		cart.setTotalQuantity(0);
		return cartRepository.save(cart);
		
		}
	return null;
	}
	
	public boolean checkProductInCart (long idUser, long idProduct) {
		
		 User user = new User();
		 user.setIdUser(idUser);
		 Product product = new Product();
		 product.setIdProduct(idProduct);
		 
		if(cartRepository.findByUser(user)!= null) {
			
			if(cartRepository.findByProduct(product)!=null) {
				return true;
			}
			else {
				return false;
			}
		}
		
	return false;
		
		
		
	}
	
	
	public Cart changeQuantity(Cart cart, Integer quantity) {
	    if (cart != null) {
	
	        cart.setTotalQuantity(quantity);
	        return cartRepository.save(cart);
	    }
	    return null;
	}


	
   
	
	
	
	


	
}
