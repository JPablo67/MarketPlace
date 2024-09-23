package com.acostajp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acostajp.model.Category;
import com.acostajp.model.Product;
import com.acostajp.model.User;
import com.acostajp.repository.ICategoryRepository;
import com.acostajp.repository.IProductRepository;


@Service
public class CategoryService {

	@Autowired
	   private ICategoryRepository categoryRepository;
	
	@Autowired
	   private IProductRepository productRepository;
	
	 
	 
	 public List<Category> categories() {
	        return categoryRepository.findAll();
	    }
	 
	 public Category save(Category category) {
	        return categoryRepository.save(category);
	    }
	 
	 public void delete(Long idCategory) {
	         categoryRepository.deleteById(idCategory);
	    }
	 
	 public Category getCategoryById(Long idCategory) {
	        return categoryRepository.findById(idCategory).orElse(null);
	    }
	 
	 public List<Product> getProductsByCategory(long idCategory){
		 Category category = new Category();
		 category.setIdCategory(idCategory);
		 List<Product> listaProductosCategoria =  productRepository.findByCategory(category);
		 return listaProductosCategoria;
	    
	 }
	 
	 public Category getProductsByCategoryName(String categoryName){
		 
		return categoryRepository.findByCategoryName(categoryName);
	    
	 }
	 


	
}
