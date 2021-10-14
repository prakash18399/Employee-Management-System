package com.mindtree.employeemanagerapp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.employeemanagerapp.model.Employee;
import com.mindtree.employeemanagerapp.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringbootBackendApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	// Create Employee Test

	@Test
	@Order(1)
	public void saveEmployeeTest() {

		Employee employee = new Employee("Prakash", "Chaudhary", "prakash@gmail.com");

		employeeRepository.save(employee);
		
		Optional<Employee> optionalEmployee = employeeRepository.findByEmailId("prakash@gmail.com");

		assertTrue(optionalEmployee.isPresent());
		
		Assertions.assertThat(employee.getId()).isGreaterThan(0);
	}

	// Get Single Employee Test

	@Test
	@Order(2)
	public void getEmployeeTest() {

		Employee employee = employeeRepository.findById(1L).get();

		Assertions.assertThat(employee.getId()).isEqualTo(1L);

	}

	// Get List of All Employee Test

	@Test
	@Order(3)
	public void getListOfEmployeesTest() {

		List<Employee> employees = employeeRepository.findAll();

		Assertions.assertThat(employees.size()).isGreaterThan(0);

	}

	// Update Employee Test

	@Test
	@Order(4)
	public void updateEmployeeTest() {

		Employee employee = employeeRepository.findById(1L).get();

		employee.setEmailId("prakashNew@gmail.com");

		Employee employeeUpdated = employeeRepository.save(employee);

		Assertions.assertThat(employeeUpdated.getEmailId()).isEqualTo("prakashNew@gmail.com");

	}

	// Delete Employee Test

	@Test
	@Order(5)
	public void deleteEmployeeTest() {

		Employee employee = employeeRepository.findById(1L).get();

		employeeRepository.delete(employee);

		Employee employee1 = null;

		Optional<Employee> optionalEmployee = employeeRepository.findByEmailId("prakashNew@gmail.com");

		if (optionalEmployee.isPresent()) {
			employee1 = optionalEmployee.get();
		}

		Assertions.assertThat(employee1).isNull();
	}
}
