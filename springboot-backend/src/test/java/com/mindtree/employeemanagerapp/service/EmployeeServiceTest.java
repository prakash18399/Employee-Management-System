package com.mindtree.employeemanagerapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
		Employee employee = new Employee("Prakash", "Chaudhary", "prakash@gmail.com");
		
		employeeRepository.save(employee);

	}

	@Test
	@DisplayName("Get Data based on Valid Employee Email")
	public void whenValidEmployeeEmailId_thenEmployeeShouldFound() {
		String employeeEmail = "prakash@gmail.com";
		Employee found = employeeService.findByEmailId(employeeEmail);

		assertEquals(employeeEmail, found.getEmailId());
	}
}
