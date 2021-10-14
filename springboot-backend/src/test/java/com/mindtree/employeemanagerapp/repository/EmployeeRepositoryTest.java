package com.mindtree.employeemanagerapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.employeemanagerapp.model.Employee;

@SpringBootTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
		Employee employee = new Employee("Prakash", "Chaudhary", "prakash@gmail.com");

		employeeRepository.save(employee);
	}

	@Test
	public void whenFindById_thenReturnEmployee() {
		Employee employee = employeeRepository.findById(1L).get();
		assertEquals(employee.getFirstName(), "Prakash");
	}

}
