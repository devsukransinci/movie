package com.tobeto.dto.employee;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetResponseEmployeeDTO {
	private UUID id;
	private String employeeName;
	private String employeePassword;

}
