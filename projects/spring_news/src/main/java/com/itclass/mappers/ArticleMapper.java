package com.itclass.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import com.itclass.models.Article;

public class ArticleMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet result, int index) throws SQLException {
		
		int id = result.getInt("id");
		String title = result.getString("title");
		String author = result.getString("author");
		String text = result.getString("text");
		Timestamp date = result.getTimestamp("date");
		
		Article article = new Article(id, title, author, text, date);	
		
		return article;
	}

}
