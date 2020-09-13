package com.asish.service;

import java.util.List;

import com.asish.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleById(int theId);
	
}
