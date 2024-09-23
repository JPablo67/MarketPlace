package com.acostajp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acostajp.model.Inventory;


public interface IInventoryRepository  extends JpaRepository<Inventory, Long>{

}
