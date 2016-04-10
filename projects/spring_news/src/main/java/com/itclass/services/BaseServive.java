package com.itclass.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseServive implements AutoCloseable {

	final protected Connection connection;
	
	public BaseServive() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:h2:~/newsdb";
		String user = "igor";
		String password = "123";
		String driver = "org.h2.Driver";
		
		Class.forName(driver);
		
		connection = DriverManager.getConnection(url, user, password);
	}
	
	@Override
	public void close() throws Exception {
		if(connection!=null) {
			connection.close();
		}
	}
	
}
