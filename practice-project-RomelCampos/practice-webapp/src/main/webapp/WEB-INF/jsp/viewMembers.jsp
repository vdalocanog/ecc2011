<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<meta charset="UTF-8">
<head>
<title>${ user.firstName } ${ user.lastName }</title>
<link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
</head>
<body>
	<div id="wrapper">
		<header>
			${ message }
		</header>
		<nav>
		</nav>
		<section>
			<div id="memberList">
				<c:choose>
					<c:when test="${fn:length(memberList) > 0}">
					    <h4>Existing Members: </h4>
					    <ul>
					   		<c:forEach items="${memberList}" var="user" varStatus="i">
					    		<li>${ user.firstName } ${ user.lastName } (${ user.userName })</li>
					    	</c:forEach>
					    </ul>
					    <div id="orgReport">
							<a href="jasper/report/download">Download Report</a>
						</div>
					</c:when>
					<c:otherwise>
						No members yet.
					</c:otherwise>
				</c:choose>
			</div>
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>
</body>
</html>