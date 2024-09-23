package com.acostajp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acostajp.model.Category;



public interface ICategoryRepository  extends JpaRepository<Category, Long>{

	Category findByCategoryName(String categoryName);
}
