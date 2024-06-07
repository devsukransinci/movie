package com.tobeto.dto.employee;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditRequestEmployeeDTO {
	private UUID id;
	private String currentEmployeePassword;
	private String newEmployeePassword;

}
