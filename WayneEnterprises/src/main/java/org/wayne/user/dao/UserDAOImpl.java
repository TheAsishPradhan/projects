package org.wayne.user.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.wayne.user.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	private EntityManager entityManager;

	@Override
	public List<User> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<User> theQuery = session.createQuery("from User",User.class);
		List<User> userList = theQuery.getResultList();
		return userList;
	}

	@Override
	public void deleteUser(User theUser) {
		// delete user
	}

	@Override
	public User updateUser(User theUser) {
		// TODO Auto-generated method stub
		return null;
	}

}
