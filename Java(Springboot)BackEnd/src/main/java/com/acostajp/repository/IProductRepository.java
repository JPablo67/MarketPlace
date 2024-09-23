package com.acostajp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acostajp.model.Cart;
import com.acostajp.model.Category;
import com.acostajp.model.Product;
import com.acostajp.model.Supplier;

@Repository
public interface IProductRepository  extends JpaRepository<Product, Long>{

	List<Product> findByCategory (Category category);
	
	List<Product> findBySupplier (Supplier supplier);
	
	
	
	
}
