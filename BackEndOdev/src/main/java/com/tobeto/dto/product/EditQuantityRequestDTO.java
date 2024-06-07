package com.tobeto.dto.product;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditQuantityRequestDTO {
	private UUID id;
	private int productQuantity;
}
