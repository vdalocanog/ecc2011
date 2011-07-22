<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${ uname }" /></title>
</head>
<body>
	<h1>Welcome <c:out value="${ uname }" /></h1>
	<ul>
		<li><a href="viewProfile.htm">View Profile</a></li>
		<li><a href="editUser.htm">Edit Profile</a></li>
		<li><a href="viewOrgs.htm">View Organizations</a></li>
		<li><a href="deleteUser.htm">Delete Account</a></li>
	</ul>
</body>
</html>