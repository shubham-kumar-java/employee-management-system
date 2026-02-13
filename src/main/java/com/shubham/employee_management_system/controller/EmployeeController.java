package com.shubham.employee_management_system.controller;

import com.shubham.employee_management_system.entity.Employee;
import com.shubham.employee_management_system.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@GetMapping
	public List<Employee> getAll() {
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteEmployee(id);
	}
}
