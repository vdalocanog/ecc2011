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
<title>Org Profile</title>
<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<link rel="stylesheet" href="js/jquery-ui-1.8.14.custom/development-bundle/demos/demos.css">
<link rel="stylesheet" href="js/jquery-ui-1.8.14.custom/development-bundle/themes/base/jquery.ui.all.css">

<script type="text/javascript">
     var jq = jQuery.noConflict();
</script>

<script type="text/javascript">
function verifyOrgName() {
 jq(function() {
  // Call a URL and pass two arguments
  // Also pass a call back function
  // See http://api.jquery.com/jQuery.post/
  // See http://api.jquery.com/jQuery.ajax/
  // You might find a warning in Firefox: Warning: Unexpected token in attribute selector: '!'
  // See http://bugs.jquery.com/ticket/7535
  jq.post("/practice-webapp/verifyOrgName.htm",
     {  oname:  jq("#oname").val() },
      function(data){
       // data contains the result
       // Assign result to the sum id
       jq("#orgNameMessage").replaceWith('<span id="orgNameMessage">'+ data + '</span>');
       jq("#message").replaceWith('');
     });
 });
}
</script>

</head>

<body>
	<div id="wrapper">
	
		<section>
		
			<div id="message">${ message }</div>
			
			<form:form method="POST"  id="saveOrgForm" commandName="org">
			
				<!-- org name must be unique -->
			    <label for="orgName">Org Name</label>
			    <form:input type="text" id="oname" path="orgName" onkeyup="verifyOrgName()" placeholder="required" value="${ org.orgName }" REQUIRED="REQUIRED" AUTOFOCUS="AUTOFOCUS"/>
			    <span id="orgNameMessage"></span>
			    
			  	<br/>
			  	
			  	<input type="submit" value="Save Org" name="btnSubmit" id="btnSubmit" />
			  	
			</form:form>
			
		</section>
		
	</div>
</body>
</html>
