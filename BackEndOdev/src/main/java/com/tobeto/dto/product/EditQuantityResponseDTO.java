package com.tobeto.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EditQuantityResponseDTO {
	private int productQuantity;
	private String responseMessage;
}
