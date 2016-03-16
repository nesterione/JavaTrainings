package com.itclass.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.itclass.model.Article;

public class ArticleService extends BaseServive {
	
	public ArticleService() throws ClassNotFoundException, SQLException {
		super();
	}

	final private String SELECT_QUERY = "SELECT * FROM ARTICLES ";
	final private String GET_BY_ID_QUERY = "SELECT * FROM ARTICLES WHERE id=?";
	final private String INSERT_QUERY =
			"insert into articles(title, author, text, date) values( ?, ?, ?, ?);";
	final private String DELETE_QUERY =
			"DELETE FROM articles where id = ?";
	
	public void save(Article article) throws Exception {
		
		try( PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY) ) {
			
			preparedStatement.setString(1, article.getTitle());
			preparedStatement.setString(2, article.getAuthor());
			preparedStatement.setString(3, article.getText());
			
			java.sql.Timestamp date = new java.sql.Timestamp( 
					article.getDate().getTime() 
				);
			
			preparedStatement.setTimestamp(4, date);
			
			
			int changed = preparedStatement.executeUpdate();
			
			if(changed==0) {
				throw new Exception("Record not saved");
			}
			
		}
		
	}
	
	public List<Article> getAll() throws SQLException {
		
		List<Article> articles = new ArrayList<>();
	
		try (PreparedStatement statement 
				= connection.prepareStatement(SELECT_QUERY) ) {
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				
				int id = result.getInt("id");
				String title = result.getString("title");
				String author = result.getString("author");
				String text = result.getString("text");
				Timestamp date = result.getTimestamp("date");
				
				Article article = new Article(id, title, author, text, date);
				 
				articles.add(article);
			}
			
			
		}
		
		return articles;
	}
	
	public void remove(int id) throws SQLException {
		
		try(PreparedStatement preparedStatement 
				= connection.prepareStatement(DELETE_QUERY)) {
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} 
	}
	
	public Article getById(int id) throws SQLException {
				
		Article article = null;
		
		try( PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID_QUERY) ) {
			
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if(result.next()) {
				
				String title = result.getString("title");
				String author = result.getString("author");
				String text = result.getString("text");
				Timestamp date = result.getTimestamp("date");
				
				article = new Article(id, title, author, text, date);
			}
		}
		
		return article;
	}
		
}
