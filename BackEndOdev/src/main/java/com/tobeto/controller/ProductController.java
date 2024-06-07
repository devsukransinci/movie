package com.tobeto.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.dto.product.AddResponseProductDTO;
import com.tobeto.dto.product.DelRequestProductDTO;
import com.tobeto.dto.product.DelResponseProductDTO;
import com.tobeto.dto.product.EditQuantityRequestDTO;
import com.tobeto.dto.product.EditQuantityResponseDTO;
import com.tobeto.dto.product.ProductDTO;
import com.tobeto.entity.Product;
import com.tobeto.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	// @formatter:off
		
		
		
	// @formatter:on

	@PostMapping("/add")
	public AddResponseProductDTO addProduct(@RequestBody ProductDTO productDTO) {
		System.out.println("add Product kismindayiz.");
		Product product = requestMapper.map(productDTO, Product.class);
		System.out.println(product);
		productService.createProduct(product);
		return new AddResponseProductDTO(product.getId(), product.getProductName());
	}

	@GetMapping("/get")
	public void getProduct() {
		System.out.println("get Product kismindayiz.");
	}

	@DeleteMapping("/del")
	public DelResponseProductDTO getProduct(@RequestBody DelRequestProductDTO dto) {
		System.out.println("get Product kismindayiz.");
		System.out.println(dto);
		productService.deleteProduct(dto.getId());
		return new DelResponseProductDTO();
	}

	@PutMapping("/edit/quantity")
	public EditQuantityResponseDTO editProductQuantity(@RequestBody EditQuantityRequestDTO dto) {
		productService.editProductQuantity(dto.getId(), dto.getProductQuantity());
		// productService.editProductQuantity(null);
		System.out.println("edit Product kismindayiz.");
		return new EditQuantityResponseDTO(dto.getProductQuantity(), "Product quantity changed.");
	}

}