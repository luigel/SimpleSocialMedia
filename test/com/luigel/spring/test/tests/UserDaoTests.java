package com.luigel.spring.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luigel.spring.dao.User;
import com.luigel.spring.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { 
		"classpath:com/luigel/spring/config/dao-context.xml",
		"classpath:com/luigel/spring/config/security-context.xml",
		"classpath:com/luigel/spring/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from user");
	}
	
	@Test
	public void testExists() {
		
		User user = new User("luigel20", "rigel1234","Rigel", "Padillo", "Carbonel", "rigel@email.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "ROLE_USER");
		usersDao.create(user);
		
		assertTrue("User should exist.", usersDao.exists(user.getUsername()));
		assertFalse("User should not exist. ", usersDao.exists("qwjdqjwd"));
	}
	
	@Test
	public void testUsers() {
		User user = new User("luigel20", "rigel1234","Rigel", "Padillo", "Carbonel", "rigel@email.com", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), "ROLE_USER");
		
		usersDao.create(user);
		
		java.util.List<User> users = usersDao.getAllUsers();
		
		assertEquals("Number of users should be 1.", 1, users.size());
		assertTrue("User should exist.", usersDao.exists(user.getUsername()));
		
		assertEquals("Created user should be identical to retrieved user", user, users.get(0));
	}

}
