package com.acostajp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acostajp.model.Category;
import com.acostajp.model.Product;
import com.acostajp.model.Supplier;
import com.acostajp.repository.IProductRepository;
import com.acostajp.repository.ISupplierRepository;


@Service
public class SupplierService {


    @Autowired
	private ISupplierRepository supplierRepository;
    
    @Autowired
	   private IProductRepository productRepository;
	 
    public List<Supplier> suppliers() {
        return supplierRepository.findAll();
    }
	 
	 public Supplier save(Supplier supplier) {
	        return supplierRepository.save(supplier);
	    }

	 public void delete(Long idSupplier) {
		 supplierRepository.deleteById(idSupplier);
	    }

	 
	 
	 public Supplier findByIdSupplier(Long idSupplier) {
	        return supplierRepository.findById(idSupplier).orElse(null);
	    }

	 public Supplier findSupplierBynameSupplier(String nameSupplier) {
	        return supplierRepository.findSupplierBynameSupplier(nameSupplier);
	    }

	 
	
	 
	 public List<Product> getProductsBySupplier(long idSupplier){
		 Supplier supplier = new Supplier();
		 supplier.setIdSupplier(idSupplier);
		 List<Product> listaProductosSupplier =  productRepository.findBySupplier(supplier);
		 return listaProductosSupplier;
	    
	 }
}
