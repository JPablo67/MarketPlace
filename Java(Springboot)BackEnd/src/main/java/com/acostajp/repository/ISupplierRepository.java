package com.acostajp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acostajp.model.Supplier;

public interface ISupplierRepository  extends JpaRepository<Supplier, Long>{

	Supplier findSupplierBynameSupplier (String nameSupplier);
	
}
