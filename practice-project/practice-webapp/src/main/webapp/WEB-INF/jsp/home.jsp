<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>${ uname }</title>
</head>
<body>
	<h1>Welcome ${ uname }</h1>
	<ul>
		<li><a href="viewProfile.htm">View Profile</a></li>
		<li><a href="editUser.htm">Edit Profile</a></li>
		<li><a href="viewOrgs.htm">View Organizations</a></li>
		<li><a href="deleteUser.htm">Delete Account</a></li>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="saveOrg.htm">Create Org</a></li>
		</sec:authorize>
		
		<hr />
		<li><a href="<c:url value="j_spring_security_logout"/>">Log-out</a></li>
	</ul>
</body>
</html>