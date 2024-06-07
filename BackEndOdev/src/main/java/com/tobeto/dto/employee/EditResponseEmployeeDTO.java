package com.tobeto.dto.employee;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditResponseEmployeeDTO {
	private UUID id;
	private String employeePassword;

}
