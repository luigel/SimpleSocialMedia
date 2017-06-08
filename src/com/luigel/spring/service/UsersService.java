package com.luigel.spring.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.luigel.spring.dao.User;
import com.luigel.spring.dao.UsersDao;

@Service("usersService")
public class UsersService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsersDao usersDao;

	public void create(User user) {

		usersDao.create(user);
	}

	public boolean exists(String username) {

		return usersDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {

		return usersDao.getAllUsers();
	}

	public User getUser(String username) {
		return usersDao.getUser(username);
	}
}
