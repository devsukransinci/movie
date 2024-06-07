package com.tobeto.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Product;
import com.tobeto.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	// CRUD: Create Read Update Delete
	public void createProduct(Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(UUID id) {
		productRepository.deleteById(id);
	}

	// List<Product> products = productRepository.findAll(); / get all Product
	// entity

	public void editProductQuantity(UUID id, int newProductQuantity) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			product.get().setProductQuantity(newProductQuantity);
			createProduct(product.get());
		}
	}


}
