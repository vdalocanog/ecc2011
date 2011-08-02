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
<meta charset="UTF-8">
<head>
  <title>${ user.firstName } ${ user.lastName } Users</title>
  <link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
  <script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
  <!-- <script type="text/javascript" src="js/json.min.js"></script>  -->
  
  
  <link rel="stylesheet" href="js/jquery-autocomplete/demo/main.css" type="text/css" />
  <link rel="stylesheet" href="js/jquery-autocomplete/jquery.autocomplete.css" type="text/css" />
  <script type="text/javascript" src="js/jquery-autocomplete/lib/jquery.bgiframe.min.js"></script>
  <script type="text/javascript" src="js/jquery-autocomplete/lib/jquery.dimensions.js"></script>
  <script type="text/javascript" src="js/jquery-autocomplete/jquery.autocomplete.js"></script>
  
  
	<script>
	
	function suggest() {
		
		$("#resultList").html('');
		
	 $.getJSON("/practice-webapp/getUserList.htm", 
		{ searchee: $("#searchee").val() }, 
		  function(result) {
			
			if ( result.userList.length > 0 ) {
				
				$.each(result.userList, function(index, value) { 
					  $("#resultList").append('<li>'+ 
							  value.userName +
							  ' (enabled:'+value.enabled+
							  '<sec:authorize access="hasRole('ROLE_ADMIN')">' +
							  ' <a href="toggleEnable.htm?userId='+value.userId+'">Toggle</a>' +
							  '</sec:authorize>' +
								')' +
							  ' (<a href="viewProfile.htm?userId='+value.userId+'">View Profile</a>)' +
							  
							  '</li>');
					});
				
				$("#searchee").autocomplete(result.userNameList);
			
			} else { 
				$("#resultList").html('No Match Found!');
			}
			
	    });
	 
		 
	}


	</script>

</head>

					    	
<body>
	<div id="wrapper">
		<header>
			${ message }
		</header>
		<nav>
		</nav>
		<section>
			<div id="userReport">
				<a href="jasper/report/user/download">Download List of All Users</a>
			</div>
			Search User Name: <input id="searchee"  onkeyup="suggest()" /> 
			<ul id="resultList"></ul>
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>
</body>



</html>