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
	@Transactional
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

}
