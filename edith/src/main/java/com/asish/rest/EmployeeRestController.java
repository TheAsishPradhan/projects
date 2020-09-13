package com.asish.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asish.dao.EmployeeDAO;
import com.asish.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeDAO employeeDao;

	public EmployeeRestController(EmployeeDAO theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	@RequestMapping("/hello")
	public String hell() {
		return "Hello World";
	}
}
