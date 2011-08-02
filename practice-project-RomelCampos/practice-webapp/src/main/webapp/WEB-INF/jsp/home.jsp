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
<head>
<meta charset="UTF-8">
<title>${ user.firstName }</title>
<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<link REL="SHORTCUT ICON" HREF="resources/images/ecc.jpg">
<link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
<style>
	a:link			{color: #F06;text-decoration: none;}
	a:visited 		{text-decoration: none;color: #F06;}
	a:hover 		{text-decoration: underline;color: #09F;}
	a:active		{text-decoration: none;color: #09F;}
	
	#close{
		font-size:14px;
		color:#6fa5fd;
		font-weight:700;
		display:block;
	}
	a{
		cursor: pointer;
		text-decoration:none;
	}
</style>
<script>
	$(function(){
		var loadingIcon = "<img src='resources/images/loading2.gif' width='50spx' height='12px' />";
		var loadingIcon2 = "<img src='resources/images/loading1.gif' />";
		var status = $('#status').val(); 
		
		switch(status){
			case "viewUser":
				loadAjax('viewUser.htm', '#loading1');
				break;
			/* case "editUser":
				loadAjax('editUser.htm', '#loading2');
				break; */
			case "org":
				loadAjax('org.htm', '#loading3');
				break;
			default: break;
		} 
		
		function loadAjax(url, x){
			loadingIcons(x);
			$('#result').load(url, function(){
				$(x).html("");
			});
		}
		
		function loadingIcons(x){
			$(x).html(loadingIcon);
			$('#result').html(loadingIcon2);
		}
		
		$('#viewUser').click(function(){
			loadAjax('viewUser.htm', '#loading1');
		});
		
		/* $('#editUser').click(function(){
			loadAjax('editUser.htm', '#loading2');
		});  */
		
		$('#viewOrgs').click(function(){
			loadAjax('org.htm', '#loading3');
		});
		
	});
</script>
</head>
<body>
	<input type="hidden" id="status" value="<%= session.getAttribute("status") %>" />
	<div style="float: left"></div>
		<h1 style="width: 300px">Welcome ${ user.firstName }</h1>
		<a href="search/index.htm" style="margin-top: -50px;margin-right: 100px; float: right"><input type="button" value="search" /></a>
		<hr />
		<ul>
			<li><a href="#" id="viewUser">View Profile</a> <span id="loading1"></span></li>
			<li><a href="editUser.htm" id="editUser">Edit Profile</a> <span id="loading2"></span></li>
			<li><a href="#" id="viewOrgs">Organizations</a> <span id="loading3"></span></li>
			<li><a href="#" id="deleteUser">Delete Account</a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<li><a href="saveOrg.htm">Create Org</a></li>
			</sec:authorize>
			<li><a href="<c:url value="j_spring_security_logout"/>">Log-out</a></li>
		</ul>
		
	<div id="result" style="float: center"></div>
<%-- =======
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
	<p>
		Username:${user.userName }
		<br>
		First Name: ${user.firstName }
		<br>
		Last Name: ${user.lastName }
		<br>
		Gender: ${user.gender }
		<br>
		E-mail: ${user.emailAddress }
	</p>
>>>>>>> 75dbb6d9b09ae56b3316d0bc059cdc3754bafa1f --%>
</body>
</html>