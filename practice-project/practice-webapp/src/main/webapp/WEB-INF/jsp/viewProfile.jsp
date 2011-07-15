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
</head>
<body>
	<div id="wrapper">
		<header>
		</header>
		<nav>
		</nav>
		<section>
			<div id="userInfo">
				${listJoinedOrgs} <br />
				<c:out value="${listJoinedOrgs}"/>
				Name: ${ user.firstName } ${ user.lastName } <br />
				Email: ${ user.emailAddress } <br />
				Gender: ${ user.gender } <br />
				Birthday: ${ user.birthDate } <br />
				Home: ${ user.homeAddress } <br />
				Contact Number: ${ user.contactNumber }
			</div> 
			<div id="userOrgs">
				<c:choose>
					<c:when test="${fn:length(listJoinedOrgs) > 0}">
					    <h4>Organizations</h4>
					    <ul>
					   		<c:forEach items="${listJoinedOrgs}" var="org" varStatus="i">
					    		<li><a href="viewMembers.htm">org.orgName</a></li>
					    	</c:forEach>
					    </ul>
					    <p>Ganahan pa ka mo-apil ug lain nga organisasiyon? Pislita <a href="#">ni</a>.</p>
					</c:when>
					<c:otherwise>
					    <p>Wala kay organisasyon nga gi-apilan! 
					    Click <a href="#">here</a> para mu-apil.</p>
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