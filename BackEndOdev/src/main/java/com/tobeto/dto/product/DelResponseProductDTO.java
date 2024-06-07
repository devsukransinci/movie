package com.tobeto.dto.product;

import java.util.UUID;

import lombok.Data;

@Data
public class DelResponseProductDTO {
	private UUID id;
	private String productName;
}
