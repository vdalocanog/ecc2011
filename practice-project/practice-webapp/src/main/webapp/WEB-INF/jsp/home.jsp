<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>${ uname }</title>
<link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
</head>
<body>

	<div id="wrapper">
		<header>
		</header>
		<nav>
		</nav>
		<section>
			
			<h1>Welcome ${ uname }</h1>
			<ul>
				<li><a href="viewProfile.htm">View Profile</a></li>
				<li><a href="editUser.htm">Edit Profile</a></li>
				<li><a href="searchOrgs.htm">View Organizations</a></li>
				<li><a href="deleteUser.htm">Delete Account</a></li>
				
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="saveOrg.htm">Create Org</a></li>
					<li><a href="searchUsers.htm">View Users</a></li>
				</sec:authorize>
				
				<hr />
				<li><a href="<c:url value="j_spring_security_logout"/>">Log-out</a></li>
			</ul>
		
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>
	
</body>
</html>