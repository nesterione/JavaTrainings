package com.itclass.controller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itclass.models.Article;
import com.itclass.services.ArticleService;

@Controller
@RequestMapping("article")
public class ArticleController {

	@Autowired
	ArticleService service;
	
	@RequestMapping("all")
	public String showAll(Model model) throws SQLException {
		
		List<Article> articles = service.getAll();
		model.addAttribute("articles",articles);
		return "index";
	}
	
	@RequestMapping("/{id}")
	public String getById(Model model,@PathVariable("id") int id) throws SQLException {
		Article article = service.getById(id);
		model.addAttribute("article", article);
		return "article";
	}
	
	@RequestMapping("/new")
	public String createArticle() {
		return "create";
	}
	
	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String saveArticle(Article article) {
		article.setDate(new Date());
		service.save(article);
		return "redirect:all";
	}
	
	@RequestMapping(value = "/remove/{id}", method=RequestMethod.POST)
	public String removeArticle(@PathVariable("id") int id) {
		service.remove(id);
		return "redirect:/article/all";
	}
	
}