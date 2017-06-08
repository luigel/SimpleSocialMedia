package com.luigel.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("usersDao")
public class UsersDao {
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	 
	public Session session() { 
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void create(User user) {
		
		System.out.println(user);
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
	}

	public boolean exists(String username) {
		
		return getUser(username) != null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		
		return session().createQuery("from user").list();

	}

	public User getUser(String username) {
		Criteria criteria = session().createCriteria(User.class);
		criteria.add(Restrictions.idEq(username));
		return (User)criteria.uniqueResult();
	}
		
}
