package com.itclass.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.itclass.mappers.ArticleMapper;
import com.itclass.models.Article;

@Service
public class ArticleService extends BaseServive {
	
	private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }
    
	public List<Article> getAll() throws SQLException {
		return jdbcTemplate.query(SELECT_QUERY, new ArticleMapper());
	}
	
	public ArticleService() throws ClassNotFoundException, SQLException {
		super();
	}

	final private String SELECT_QUERY = "SELECT * FROM ARTICLES ";
	final private String GET_BY_ID_QUERY = "SELECT * FROM ARTICLES WHERE id=?";
	final private String INSERT_QUERY =
			"insert into articles(title, author, text, date) values( ?, ?, ?, ?);";
	final private String DELETE_QUERY =
			"DELETE FROM articles where id = ?";
	
	public void save(Article article)  {
		
		jdbcTemplate.update(INSERT_QUERY, 
				article.getTitle(),
				article.getAuthor(),
				article.getText(),
				new java.sql.Timestamp(article.getDate().getTime()));
		
	}

	public void remove(int id) {
		jdbcTemplate.update(DELETE_QUERY,id);
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
