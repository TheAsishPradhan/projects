package org.wayne.user.dao;

import java.util.List;

import org.wayne.user.entity.User;

public interface UserDAO {
	public List<User> findAll();

	public void deleteUser(User theUser);

	public User updateUser(User theUser);
}
