package com.tobeto.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(UUID id) {
		employeeRepository.deleteById(id);
	}

	@Transactional
	public Employee getEmployee(UUID id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			System.out.println("Var :)");
		} else {
			System.out.println("Yok :(");
		}
		return employee.get();
	}

	public void changePassword(UUID id, String oldPassword, String newPassword) {
		Optional<Employee> employee = Optional.of(getEmployee(id));
		if (employee.get().getEmployeePassword().equals(oldPassword)) {
			employee.get().setEmployeePassword(newPassword);
			addEmployee(employee.get());
		}
	}
}