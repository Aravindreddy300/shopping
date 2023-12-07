package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Employee;
import com.shopping.exception.EmployeeNotFoundException;
import com.shopping.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		logger.info("get all employees");
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		logger.info("get employee details by ID");
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/create")
	public Employee addEmployee(@RequestBody Employee employee) {
		logger.info("creating employee");
		return employeeService.saveEmployee(employee);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
		logger.info("updating employees");
		return employeeService.updateEmployee(id, newEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		logger.info("deleting answers");
		employeeService.deleteEmployee(id);
	}
	
	 // Global Exception Handling
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleCustomerNotFoundException(EmployeeNotFoundException ex) {
        return ex.getMessage();
    }
}
