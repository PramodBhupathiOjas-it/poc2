package com.ojas.poc2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.poc2.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer> {
	
	
}
