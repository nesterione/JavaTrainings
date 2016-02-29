<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><jsp:invoke fragment="header"/></title>

<link rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/style.css" />

</head> 
 <body>
 	<div class="wrap">
 		<jsp:doBody/>
 	
 	<hr>
 	<footer>
 	
 	All right 
 	</footer>
 	
 	</div>
 </body>
 </html>