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
		</header>
		<nav>
		</nav>
		<section>
			<div id="userInfo">
				<p><span class="bold">Name:</span> ${ user.firstName } ${ user.lastName } </p>
				<p><span class="bold">Email:</span> ${ user.emailAddress } </p>
				<p><span class="bold">Gender:</span> ${ user.gender } </p>
				<p><span class="bold">Birthday:</span> ${ user.birthDate } &nbsp;</p> 
				<p><span class="bold">Home:</span> ${ user.homeAddress } &nbsp;</p>
				<p><span class="bold">Contact Number:</span> ${ user.contactNumber } &nbsp;</p>
				<br />
			</div> 
			<hr />
			<div id="userOrgs">
				<c:choose>
					<c:when test="${fn:length(user.orgs) > 0}">
					    <h4>Organizations: </h4>
					    <ul>
					   		<c:forEach items="${user.orgs}" var="org" varStatus="i">
					    		<li>
					    			${ org.orgName }
					    			(<a href="viewMembers.htm?orgId=${ org.orgId }">View Members</a>)
					    			(<a href="leaveOrg.htm?orgId=${ org.orgId }">Leave</a>)
					    		</li>
					    	</c:forEach>
					    </ul>
					    <p>Ganahan pa ka mo-apil ug lain nga organisasiyon? Pislita <a href="viewOrgs.htm">ni</a>.</p>
					</c:when>
					<c:otherwise>
					    <p>Wala kay organisasyon nga gi-apilan! Click <a href="viewOrgs.htm">here</a> para mu-apil.</p>
					</c:otherwise>
				</c:choose>
				<p>Click <a href="jasper/report/user/download/report.pdf?userId=${ user.userId }">here</a> to download PDF.</p>
			</div>
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>
</body>
</html>