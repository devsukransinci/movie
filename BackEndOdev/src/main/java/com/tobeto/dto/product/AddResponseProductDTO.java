package com.tobeto.dto.product;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddResponseProductDTO {
	private UUID id;
	private String productName;
}
