package com.acostajp.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acostajp.model.Sale;
import com.acostajp.model.User;



public interface ISaleRepository  extends JpaRepository<Sale, Long>{
	
	    
	Sale findByUser (User user);
	

}
