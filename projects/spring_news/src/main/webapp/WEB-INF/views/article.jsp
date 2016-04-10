<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:layout>
    <jsp:attribute name="header">Статья</jsp:attribute>
    <jsp:body>
    
	<p> <a href="home"> На главную </a>  </p>
	
    <h1> ${article.title}</h1>
    <p> ${article.author} / publication date: ${article.date}</p>
    <p> 
    	${article.text}
    </p>
    
    
</jsp:body>
</t:layout>