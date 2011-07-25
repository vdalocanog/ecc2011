<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<script src="js/jquery-ui-1.8.14.custom/development-bundle/ui/jquery.ui.core.js"></script>
<script src="js/jquery-ui-1.8.14.custom/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="js/jquery-ui-1.8.14.custom/development-bundle/ui/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" href="js/jquery-ui-1.8.14.custom/development-bundle/demos/demos.css">
<link rel="stylesheet" href="js/jquery-ui-1.8.14.custom/development-bundle/themes/base/jquery.ui.all.css">
<script>
    $(function() {
        $("#birthDate").datepicker({
            changeMonth : true,
            changeYear : true,
            dateFormat : 'yy-mm-dd',
            yearRange : '-101:-18',
            maxDate : '-18y',
            minDate : '-101y'
        });
    });
</script>
<script type="text/javascript" src="resources/javascript/register.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
</head>
<body><!-- Validate pa if short ra ang password -->
	<div id="wrapper">
		<section>
			<div id="message">${ message }</div>
			<form:form action="saveUser.htm" method="POST"  id="saveUserForm" commandName="user">
			
			    <c:choose>
					<c:when test="${action == 'edit'}">
					</c:when>
					<c:otherwise>
					    <label for="userName" class="bold2">User Name</label>
					    <form:input type="text" id="uname" path="userName" placeholder="required" value="${ user.userName }" REQUIRED="REQUIRED" AUTOFOCUS="AUTOFOCUS"/>
					    <span id="userNameMessage"></span>
					</c:otherwise>
				</c:choose>
			    
			    
			    
			    <br />
			
			    <label for="password">Password</label>
			    <form:input type="password" id="pword" path="password" placeholder="required" value="${ user.password }" REQUIRED="REQUIRED" />
			    <span id="pwordmsg"></span> <br />
			    
			    <label for="confirmPassword">Confirm Password</label>
			    <input type="password" id="pword2" name="confirmPassword" placeholder="required" value="${ confirmPassword }" REQUIRED="REQUIRED" />
			    <span id="pword2msg"></span> 
			    
			    <br />
			    
			    <label for="lastName">Last Name</label>
			    <form:input type="text" path="lastName" placeholder="required" value="${ user.lastName }" REQUIRED="REQUIRED" /> <br />
			    
			    <label for="firstName">First Name</label>
			    <form:input type="text" path="firstName" placeholder="required" value="${ user.firstName }" REQUIRED="REQUIRED" /> <br />
			    
			    <label for="mi">M.I.</label>
			    <form:input type="text" path="mi" size="5" maxlength="1" placeholder="required" value="${ user.mi }" REQUIRED="REQUIRED"/> <br />
			    
			    <label for="emailAddress">Email Address</label>
			    <form:input type="email" path="emailAddress"  placeholder="required" value="${ user.emailAddress }" REQUIRED="REQUIRED"/> <br />
			    
			    <label for="gender">Gender</label>
			    <form:input type="radio" path='gender' value='Male' />Male 
			    <form:input type="radio" path='gender' value='Female' />Female 
			    
			    <label for="birthDate">Birth Date</label>
			    <input type="text" id="birthDate" name="birthDate" readonly  value="${ user.birthDate }"/> <br />
			      
			    <label for="homeAddress">Home Address</label>
			    <form:input type="text" path="homeAddress" value="${ user.homeAddress }" /> <br />
			
			    <label for="contactNumber">Contact Number</label>
			    <form:input type="text" class="numberOnly" path="contactNumber" placeholder="numbers only" value="${ user.contactNumber }"/><br />
			
			  	<br/>
			  	<input type="submit" value="Save User" id="btnSubmit" />
			  	<input type="reset" value="Reset" />
			  	<a href='login.htm'><input type="button" value="<<Back" /></a>
			</form:form>
			Mogana ko sa Chrome: <br />
			<audio controls="controls">
			  <source src="resources/audio/JasonMraz-TryTryTry.mp3" type="audio/mp3" />
			  Your browser does not support the audio element.
			</audio>
		</section>
	</div>
</body>
</html>
