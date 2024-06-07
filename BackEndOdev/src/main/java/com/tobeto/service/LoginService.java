package com.tobeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.entity.Employee;
import com.tobeto.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;

	public boolean login(String employeeName, String employeePassword) {
		Optional<Employee> employee = loginRepository.findByEmployeeName(employeeName);
		if (employee.isPresent() && employee.get().getEmployeePassword().equals(employeePassword)) {

			System.out.println("Username exist and passwords are equal");
			return true;
		} else {
			System.out.println("Username not found or password wrong");
			return false;
		}
	}
}
