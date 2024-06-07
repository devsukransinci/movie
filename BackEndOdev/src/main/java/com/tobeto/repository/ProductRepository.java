package com.tobeto.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
	// Optional<Employee> findByUserName(String userName);
}