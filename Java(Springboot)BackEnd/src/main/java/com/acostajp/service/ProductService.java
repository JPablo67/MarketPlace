package com.acostajp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acostajp.model.Product;
import com.acostajp.model.Sale;
import com.acostajp.model.User;
import com.acostajp.repository.IProductRepository;



@Service
public class ProductService {
	
	  @Autowired
	  private IProductRepository productoRepository;

	 
	  public Product getById(Long idProduct) {
	        return productoRepository.findById(idProduct).orElse(null);
	    }
	   
	  
	 
	  

	   

}
