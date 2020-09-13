package com.asish.dao;

import java.util.List;

import com.asish.entity.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
}
