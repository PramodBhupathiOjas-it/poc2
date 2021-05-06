package com.ojas.poc2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.poc2.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
