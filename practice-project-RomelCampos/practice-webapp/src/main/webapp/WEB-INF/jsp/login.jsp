<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link REL="SHORTCUT ICON" HREF="../resources/images/ecc.jpg">
<script type="text/javascript" src="../js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<script>
	$(function(){
		if($('#username').val() == "") $('#username').focus();
		else $('#password').focus();
	});
</script>
</head>
<body>
<form action="../j_spring_security_check" method="post">
<div id="error">${ error }</div>
	<label for="username">Username:</label>
	<input type="text" name="j_username" id="username" value="${ uname }">
	<br>
	<label for="password">Password:</label>
	<input type="password" name="j_password" id="password">
	<br>
	<input type="submit" value="Login">
</form>
<a href="../register/registerVoter.htm">Click Here</a> to register.
</body>
</html>