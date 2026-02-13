package com.shubham.employee_management_system.service;

import com.shubham.employee_management_system.entity.Employee;
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
		Employee existing = repository.findById(id).orElse(null);
		
		if(existing != null) {
			existing.setName(newEmployee.getName());
			existing.setEmail(newEmployee.getEmail());
			existing.setSalary(newEmployee.getSalary());
			return repository.save(existing);
		}
		
		return null;
	}
	
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
	
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void deleteEmployee(Long id) {
		repository.deleteById(id);
	}
}
