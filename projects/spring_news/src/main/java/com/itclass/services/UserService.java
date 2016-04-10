package com.itclass.services;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.itclass.models.User;

@Service
public class UserService {

	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }
	
	public void registration(User user) {
		// TODO add notification when user will not registered 
		jdbcTemplate.update("insert into users(username, password) values( ?, ?)",
				user.getName(),
				user.getPassword());
		
	}
}
