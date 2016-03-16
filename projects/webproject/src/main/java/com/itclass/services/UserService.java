package com.itclass.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.itclass.model.Article;
import com.itclass.model.User;

public class UserService extends BaseServive {
	
	private final static Object lock = new Object();
	private final String SELECT_USER = "select * from users where username=?";
	
	// TODO 
	//private static Map<String , User> users = new HashMap<>();
	
	public UserService() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param login
	 * @return true - if login is free else false
	 * @throws SQLException
	 */
	public boolean checkLogin(String login) throws SQLException {
		
		try(PreparedStatement statement = connection.prepareStatement(SELECT_USER)) {
			statement.setString(1, login);
			ResultSet result = statement.executeQuery();
			
			// next вернет true когда есть хотябы одна строка, и значит логин занят
			if(result.next()) {
				return false;
			} else {
				return true;
			}
		} 
	}
	
	
	private final String INSERT_USER = 
			"insert into users(username, password) values (?,?)";
	
	public User save(String login, String password) throws SQLException {
		
		try(PreparedStatement statement 
				= connection.prepareStatement(INSERT_USER)) {
			
			statement.setString(1, login);
			statement.setString(2, password);
			
			int rowUpdated = statement.executeUpdate();
			if(rowUpdated>0) {
				
				// TODO get id 
				return new User(-1, login, password);
			}
			
		}
		
		return null;
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
	public User login(String username, String password) throws SQLException {
		
try( PreparedStatement preparedStatement 
		= connection.prepareStatement(SELECT_USER) ) {
			preparedStatement.setString(1, username);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				
				int id = result.getInt("id");
				String passDb = result.getString("password");
				
				if(passDb.equals(password)) {
					User user = new User(id,username,password);
					return user;
				}
			}
		}

		return null;		
	}

	@Override
	public void close() throws Exception {
		// TODO закрытие соединения 
		
	}

}
