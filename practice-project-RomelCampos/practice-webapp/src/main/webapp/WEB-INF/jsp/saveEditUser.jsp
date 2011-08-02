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
<body>
	<div id="wrapper">
		<section>
			<div id="message">${ message }</div>
			<form:form method="POST" action="saveEditUser.htm" id="saveUserForm" commandName="user">
			    
			    <form:input type="hidden" path="userId" value="${ user.userId }" />
			    <form:input type="hidden" path="userName" value="${ user.userName }" />
			    <form:input type="hidden" path="password" value="${ user.password }" />
			    
			    <label for="lastName">Last Name</label>
			    <form:input type="text" path="lastName" placeholder="required" value="${ user.lastName }" REQUIRED="REQUIRED" /> <br />
			    
			    <label for="firstName">First Name</label>
			    <form:input type="text" path="firstName" placeholder="required" value="${ user.firstName }" REQUIRED="REQUIRED" /> <br />
			    
			    <label for="mi">M.I.</label>
			    <form:input type="text" path="mi" size="5" maxlength="1" placeholder="required" value="${ user.mi }" REQUIRED="REQUIRED"/> <br />
			    
			    <label for="emailAddress">Email Address</label>
			    <form:input type="email" path="emailAddress"  placeholder="required" value="${ user.emailAddress }" REQUIRED="REQUIRED"/> <br />

			    <label for="gender">Gender</label>
			    <form:radiobutton path='gender' value='Male' />Male 
			    <form:radiobutton path='gender' value='Female' />Female
			    <form:input type="radio" path='gender' value='Others' checked="checked" />Others  <br />
			    
			    <label for="birthDate">Birth Date</label>
			    <form:input type="text" path="birthDate" id="birthDate" name="birthDate" value="${ user.birthDate }" readonly="true"/> <br />
			      
			    <label for="homeAddress">Home Address</label>
			    <form:input type="text" path="homeAddress" value="${ user.homeAddress }" /> <br />
			
			    <label for="contactNumber">Contact Number</label>
			    <form:input type="text" class="numberOnly" path="contactNumber" placeholder="numbers only" value="${ user.contactNumber }"/><br />
			
			  	<br/>
			  	<input type="submit" value="Save Changes" id="btnSubmit" />
			  	<input type="reset" value="Reset" />
			  	<a href='home.htm'><input type="button" value="Done" /></a>
			</form:form>
		</section>
		
		( <a href="editPassword.htm">Edit Password</a> )
		
	</div>
</body>
</html>
