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
          <input type="input name="username" />

          <label for="password">Password*</label>
          <input type="password" name="password" />   
          
          <label for="confirmPassword">Confirm Password*</label>
          <input type="password name="confirmPassword" />
          
          <label for="lastName">Last Name*</label>
          <input type="input name="lastName" />/>
          
          <label for="firstName">First Name*</label>
          <input type="input name="firstName" />
          
          <label for="mi">M.I.*</label>
          <input type="input name="mi" size="1" maxlength="1" />
          
          <label for="emailAddress">Email Address*</label>
          <input type="input name="emailAddress" />
          
          <label for="gender">Gender*</label>
          <input type="radiobutton" name='gender' value='Male' label='Male' />
          <input type="radiobutton" name='gender' value='Female' label='Female' />
          
          <label for="birthDate">Birth Date</label>
          <input type="text" id="birthDate" name="birthDate" />
			
          <label for="homeAddress">Home Address</label>
          <input type="input" name="homeAddress" />

          <label for="contactNumber">Contact Number</label>
          <input type="input" name="contactNumber" /> (numbers only.)
          
          
        </table>
        
		<div class="error">* required fields</div>
		
        <br/>
        <input type="submit" value="Save User" />
        <input type="reset" value="Reset" />
      </form>

      <a href='login.htm'>Back to Login</a><br/>

  </body>
</html>
