<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<hr>
<c:if test="${empty user}">
  <a href="login">Войти</a>
</c:if>

<c:if test="${not empty user}">
Welcome ${user} 
 <form action="logout" method="post">
 	<input type="submit" value="logout">
 </form>
</c:if>
 
<hr>