<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<!-- <html> -->
<meta charset="UTF-8">
<%-- <head>
<title>${ user.firstName } ${ user.lastName }</title>
<link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
</head>
<body> --%>
<script>
	$('#close').click(function(){
		
		$('#watever').html('');
	});
</script>
<div id="watever">
	<div id="wrapper" class="ambot">
		<header style="text-align: right; margin-top: -2px">
			<a id="close">close</a>
		</header>
		<nav>
		</nav>
		<section>
			<div id="userInfo">
				<p><span class="bold">Name:</span> ${ user.fullName } </p>
				<p><span class="bold">Email:</span> ${ user.emailAddress } </p>
				<p><span class="bold">Gender:</span> ${ user.gender } </p>
				<p><span class="bold">Birthday:</span> ${ user.birthDate } &nbsp;</p> 
				<p><span class="bold">Home:</span> ${ user.homeAddress } &nbsp;</p>
				<p><span class="bold">Contact Number:</span> ${ user.contactNumber } &nbsp;</p>
				<br />
			</div> 
			<hr />
<%-- 			<div id="userOrgs">
				<c:choose>
					<c:when test="${fn:length(user.orgs) > 0}">
					    <h4>Organizations: </h4>
					    <ul>
					   		<c:forEach items="${user.orgs}" var="org" varStatus="i">
					    		<li><a href="viewMembers.htm?orgId=${ org.orgId }">${ org.orgName }</a></li>
					    	</c:forEach>
					    </ul>
					    <p>Ganahan pa ka mo-apil ug lain nga organisasiyon? Pislita <a href="#">ni</a>.</p>
					</c:when>
					<c:otherwise>
					    <p>Wala kay organisasyon nga gi-apilan! Click <a href="org.htm">here</a> para mu-apil.</p>
					</c:otherwise>
				</c:choose> --%>
				<p>Click <a href="jasper/report/user/download">here</a> to view printable version.</p>
			<!-- </div> -->
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>
</div>
<!-- </body>
</html> -->