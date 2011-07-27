<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="../resources/css/register.css" media="screen" />
</head>
<body>

	<div id="wrapper">
		<header>
		</header>
		<nav>
		</nav>
		<section>

			<form action="../j_spring_security_check" method="post">
			<div id="error">${ error }</div>
				<label for="username">Username:</label>
				<input type="text" name="j_username" id="username">
				<br>
				<label for="password">Password:</label>
				<input type="password" name="j_password" id="password">
				<br>
				<input type="submit" value="Login">
			</form>
			<a href="../registerVoter.htm">Click Here</a> to register.
		
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>

</body>
</html>