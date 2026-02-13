package com.shubham.employee_management_system.service;

import com.shubham.employee_management_system.entity.Employee;
import com.shubham.employee_management_system.exception.ResourceNotFoundException;
import com.shubham.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	
	private final EmployeeRepository repository;
	
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	public Employee createEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee updateEmployee(Long id, Employee newEmployee) {
		Employee existing = repository.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("Employee not found with id " + id));
		
			existing.setName(newEmployee.getName());
			existing.setEmail(newEmployee.getEmail());
			existing.setSalary(newEmployee.getSalary());
			
			return repository.save(existing);
	}
	
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		return repository.findById(id)
				.orElseThrow(() ->
					new ResourceNotFoundException("Employee not found with id " + id));
	}
	
	public void deleteEmployee(Long id) {
		Employee existing = repository.findById(id)
				.orElseThrow(() ->
						new ResourceNotFoundException("Employee not found with id " + id));
		
		repository.delete(existing);
	}
}
