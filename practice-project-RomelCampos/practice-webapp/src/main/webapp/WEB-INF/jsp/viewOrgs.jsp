<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
			<div id="orgList">
				<c:choose>
					<c:when test="${fn:length(orgList) > 0}">
					    <h4>Existing Organizations: </h4>
					    <ul>
					   		<c:forEach items="${orgList}" var="org" varStatus="i">
					    		<li>
					    			<a href="viewMembers.htm">${ org.orgName }</a> 
					    			(<a href="joinOrg.htm?orgId=${ org.orgId }">Join</a>) 
					    			(<a href="viewMembers.htm?orgId=${ org.orgId }">ViewMembers</a>) 
					    			<sec:authorize access="hasRole('ROLE_ADMIN')">
					    				(<a href="deleteOrg.htm?orgId=${ org.orgId }">Delete</a>)
					    			</sec:authorize>
					    		</li>
					    	</c:forEach>
					    </ul>
					    <div id="orgReport">
							<a href="jasper/report/org/download">Download Report</a>
						</div>
					</c:when>
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