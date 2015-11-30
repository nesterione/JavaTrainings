package com.itclass.dao;

import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itclass.model.Post;

public class PostDAO extends AbstractDAO<Integer, Post> {

	final private String GET_ALL_QUERY = "select * from posts";
	
	public PostDAO() throws SQLException {
		super();
	}

	@Override
	public List<Post> getAll() throws SQLException {
		
		List<Post> posts = new ArrayList();
		PreparedStatement statement = connection.prepareStatement(GET_ALL_QUERY);
		
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
		    Integer id = resultSet.getInt("id");
		    String title = resultSet.getString("title");
		    Timestamp created = resultSet.getTimestamp("created");
		    Timestamp lastChanged = resultSet.getTimestamp("lastChanged");
		    Clob content = resultSet.getClob("content");
		    String tags = resultSet.getString("tags");
		    
		    
		    Post post = new Post(id,
		    		title, 
		    		new Date(created.getTime()),
		    		new Date(lastChanged.getTime()),
		    		// TODO только если не предпологается, что в CLOB количество символов < int
		    		content.getSubString(1L,(int)content.length() ),
		    		tags);
		    
		   posts.add(post);
		}
		
		return posts;
	}

	@Override
	public Post get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Post entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Post entity) {
		// TODO Auto-generated method stub
		
	}

}