<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Hello World Spring MVC</title>

</head>
<body>

Добро пожаловать ${name}

<form method="post">
	
	<p>id</p>
	<input type="text" name="id" />
	
	<p>name</p>
	<input type="text" name="name"/>
	
	<p>password</p>
	<input type="password" name="password"/>

	<input type="submit" value="войти" >
</form>
 
</body>
</html>