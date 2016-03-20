package com.itclass.services.hibernate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.itclass.model.Article;
import com.itclass.model.User;

public class UserService  {
	
	private final static Object lock = new Object();
	
	
	private User selectUser(String username) {
		try(Session session = SessionManager.openSession()) {
			
			User selectedUser =  (User)session
				.createCriteria(User.class, "user")
				.add(
						Restrictions.eq("user.name", username)
				).uniqueResult();
			
			return selectedUser;	
		} 
	}

	/**
	 * 
	 * @param login
	 * @return true - if login is free else false
	 * @throws SQLException
	 */
	public boolean checkLogin(String login) throws SQLException {
		
		if(selectUser(login)!=null) {
			return false;
		}
		return true;
	}
	
	public User save(String login, String password) throws SQLException {
		
		User user = new User();
		user.setName(login);
		user.setPassword(password);
		
		try(Session session = SessionManager.openSession()) {
			Transaction t = session.beginTransaction();
			
			session.save(user);
			t.commit();
		}
		
		return user;
	}
	
	public User registration(String login, String password) throws SQLException {
		
		synchronized (lock) {
			if(checkLogin(login)) {
				User user = save(login, password);
				return user;
			}
		}
		
		return null;
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @return User если авторизован, null если не авторизован 
	 * @throws SQLException 
	 */
	public User login(String username, String password) {
		
		System.out.println("login with hibernate");
		
		User user = selectUser(username);
		
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}

}
