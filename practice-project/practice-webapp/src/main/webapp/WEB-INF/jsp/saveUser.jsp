<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!doctype html>
<html>
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
<script type="text/javascript">
	$(function() {
		var loadingIcon = "<img src='resources/images/ajax-loader.gif' width='15px' height='15px' />";
		var checkIcon = "<img src='resources/images/check.png' width='15px' height='15px' />";
		var wrongIcon = "<img src='resources/images/wrong.png' width='15px' height='15px' />";
		
		$('#uname').keyup(function() {
			$('#userNameMessage').html(loadingIcon);
			$.ajax({
		    	url: 'checkUname.htm',
		    	data: ({uname : $('#uname').val()}),
		    	success: function(data) {
		    		var status = wrongIcon; 
		    		if(data == "valid") status = checkIcon;
		    		$('#userNameMessage').html(status);
		    	},
		    	error: function(){
		    		$('#userNameMessage').html("Ajax Failed.");
		    	}
			});
		});
	}); 
</script>
</head>
<body>
	<div id="wrapper">
		<section>
			<form:form action="saveUser.htm" method="POST"  id="saveUserForm" commandName="user">
			    <label for="userName">User Name*</label>
			    <form:input type="text" id="uname" path="userName" onkeyup="ajax()" placeholder="important"/>
			    <span id="userNameMessage">*</span><br />
			    
			    <br />
			
			    <label for="password">Password*</label>
			    <form:input type="password" path="password" /> <br />
			    
			    <label for="confirmPassword">Confirm Password*</label>
			    <input type="password" name="confirmPassword" /> <br />
			    
			    <br />
			    
			    <label for="lastName">Last Name*</label>
			    <form:input type="text" path="lastName" /> <br />
			    
			    <label for="firstName">First Name*</label>
			    <form:input type="text" path="firstName" /> <br />
			    
			    <label for="mi">M.I.*</label>
			    <form:input type="text" path="mi" size="1" maxlength="1" /> <br />
			    
			    <label for="emailAddress">Email Address*</label>
			    <form:input type="email" path="emailAddress" /> <br />
			    
			    <label for="gender">Gender*</label>
			    <form:input type="radio" path='gender' value='Male' />Male 
			    <form:input type="radio" path='gender' value='Female' />Female <br />
			    
			    <label for="birthDate">Birth Date</label>
			    <input type="text" id="birthDate" name="birthDate" readonly/> <br />
			      
			    <label for="homeAddress">Home Address</label>
			    <form:input type="text" path="homeAddress" /> <br />
			
			    <label for="contactNumber">Contact Number</label>
			    <form:input type="text" path="contactNumber" /> (numbers only.) <br />
			
			  
			    <div class="error">* required fields</div>
			  
			  <br/>
			  <input type="submit" value="Save User" />
			  <input type="reset" value="Reset" />
			</form:form>
			<a href='login.htm'>Back to Login</a><br/>
		</section>
	</div>
</body>
</html>
