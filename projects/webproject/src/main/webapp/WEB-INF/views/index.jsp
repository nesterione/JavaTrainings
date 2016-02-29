<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:layout>
    <jsp:attribute name="header">Главная</jsp:attribute>

    <jsp:body> 
 
		<jsp:include page="../partials/_login.jsp"/>
		
		<h2>News <a href="create">+</a></h2> 
		
		<c:forEach var="item" items="${articles}">
			<p> ${item.id}</p>
			<p> <a href="article?id=${item.id}"> ${item.title}</a></p>
			<p> ${item.author}  / 
			
			<fmt:formatDate pattern="dd.MM.yyyy hh:mm:ss" value="${item.date}"/>
			
			</p>
			 <p> 
			 	
			 	<form action="delete?id=${item.id}" method="post">
			 		<input type="submit" value="delete"> 
			 	</form>
			 	
			 </p>
			<hr>
		</c:forEach>

</jsp:body>
</t:layout>