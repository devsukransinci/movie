package com.tobeto.controller;

import java.util.UUID;

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

import com.tobeto.dto.employee.AddResponseEmployeeDTO;
import com.tobeto.dto.employee.DeleteRequestEmployeeDTO;
import com.tobeto.dto.employee.DeleteResponseEmployeeDTO;
import com.tobeto.dto.employee.EditRequestEmployeeDTO;
import com.tobeto.dto.employee.EditResponseEmployeeDTO;
import com.tobeto.dto.employee.EmployeeDTO;
import com.tobeto.dto.employee.GetRequestEmployeeDTO;
import com.tobeto.dto.employee.GetResponseEmployeeDTO;
import com.tobeto.entity.Employee;
import com.tobeto.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	@Qualifier("requestMapper")
	private ModelMapper requestMapper;
	@Autowired
	@Qualifier("responseMapper")
	private ModelMapper responseMapper;

	// @formatter:off
	
	/*@PostMapping("/yazilimIlanVer")
	public ResponseEntity<SuccessResponseDTO> yazilimIlanVer(@RequestBody YazilimIlanVerRequestDTO dto) {
		YazilimIlan yazilimIlan = requestMapper.map(dto, YazilimIlan.class);
		ilanService.yazilimIlanVer(yazilimIlan);
		return ResponseEntity.ok(new SuccessResponseDTO("ilan oluşturuldu"));
	}*/
	
	
	// @formatter:on

	@PostMapping("/add")
	public AddResponseEmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		/*
		 * JSONObject json = new JSONObject(employeeDTO);
		 * System.out.println(json.get("id"));
		 * System.out.println(json.get("employeeName"));
		 */
		Employee employee = requestMapper.map(employeeDTO, Employee.class);

		System.out.println(employeeDTO.getEmployeeName());
		System.out.println(employeeDTO.getEmployeePassword());

		employee = employeeService.addEmployee(employee);
		System.out.println("Post istegi burada");
		return new AddResponseEmployeeDTO(employee.getId());
	}

	@GetMapping("/get")
	public GetResponseEmployeeDTO getEmployee(@RequestBody GetRequestEmployeeDTO dto) {
		Employee employee = employeeService.getEmployee(dto.getId());
		System.out.println(employee);
		return new GetResponseEmployeeDTO(employee.getId(), employee.getEmployeeName(), employee.getEmployeePassword());
	}

	@DeleteMapping("/del")
	public DeleteResponseEmployeeDTO deleteEmployee(@RequestBody DeleteRequestEmployeeDTO dto) {
		UUID id = UUID.fromString(dto.getId());
		employeeService.deleteEmployee(id);
		return new DeleteResponseEmployeeDTO("Employee deleted.");
	}

	@PutMapping("/edit")
	public EditResponseEmployeeDTO editEmployee(@RequestBody EditRequestEmployeeDTO dto) {
		System.out.println(dto);
		employeeService.changePassword(dto.getId(), dto.getCurrentEmployeePassword(), dto.getNewEmployeePassword());
		System.out.println("Put istegi burada");
		return new EditResponseEmployeeDTO();
	}

}
