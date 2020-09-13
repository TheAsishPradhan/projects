package com.asish.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asish.entity.Employee;

@Repository
public class EmployeeDAOHibernateimpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOHibernateimpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		// get the hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		//save the employee
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {
		//get the session
		Session currentSession = entityManager.unwrap(Session.class);

		// prepare the query
		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();

	}

}
