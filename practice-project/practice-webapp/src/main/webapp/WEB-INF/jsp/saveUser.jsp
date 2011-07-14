<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<html>
  <head>
    <title>User Profile</title>
  </head>

  <body>
  
      <form method="POST"  id="saveForm" >
      
          <input type="hidden" name="userId" />
          
          <label for="userName">User Name*</label>
          <input type="input name="username" /> <br />

          <label for="password">Password*</label>
          <input type="password" name="password" /> <br />
          
          <label for="confirmPassword">Confirm Password*</label>
          <input type="password name="confirmPassword" /> <br />
          
          <label for="lastName">Last Name*</label>
          <input type="input name="lastName" /> <br />
          
          <label for="firstName">First Name*</label>
          <input type="input name="firstName" /> <br />
          
          <label for="mi">M.I.*</label>
          <input type="input name="mi" size="1" maxlength="1" /> <br />
          
          <label for="emailAddress">Email Address*</label>
          <input type="input name="emailAddress" /> <br />
          
          <label for="gender">Gender*</label>
          <input type="radio" name='gender' value='Male' label='Male' />
          <input type="radio" name='gender' value='Female' label='Female' /> <br />
          
          <label for="birthDate">Birth Date</label>
          <input type="text" id="birthDate" name="birthDate" /> <br />
			
          <label for="homeAddress">Home Address</label>
          <input type="input" name="homeAddress" /> <br />

          <label for="contactNumber">Contact Number</label>
          <input type="input" name="contactNumber" /> (numbers only.) <br />

        
		<div class="error">* required fields</div>
		
        <br/>
        <input type="submit" value="Save User" />
        <input type="reset" value="Reset" />
      </form>

      <a href='login.htm'>Back to Login</a><br/>

  </body>
</html>
