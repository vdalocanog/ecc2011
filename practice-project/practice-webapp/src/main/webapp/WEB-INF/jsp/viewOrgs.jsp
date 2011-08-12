<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<!doctype html>
<html>
<meta charset="UTF-8">
<head>
<title>${ user.firstName } ${ user.lastName }</title>
<link rel="stylesheet" type="text/css" href="resources/css/register.css" media="screen" />
<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>

<script type="text/javascript" src="js/jquery.tablesorter/jquery.tablesorter.min.js"></script> 
<script type="text/javascript" src="js/jquery.tablesorter/addons/pager/jquery.tablesorter.pager.js"></script> 
<link rel="stylesheet" type="text/css" href="js/jquery.tablesorter/themes/green/style.css" media="screen" />

<script>
	$(document).ready(function() 
	    { 
	        $("#myTable")
	        .tablesorter({widthFixed: true, widgets: ['zebra']})
	        .tablesorterPager({container: $("#pager")}); 
	    } 
	); 
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
			<div id="orgList">
				<c:choose>
					<c:when test="${fn:length(orgList) > 0}">
					    <h4>Existing Organizations: </h4>
					    <ul>
					   		<c:forEach items="${orgList}" var="org" varStatus="i">
					    		<li>
					    			${ org.orgName }
					    			(<a href="joinOrg.htm?orgId=${ org.orgId }">Join</a>) 
					    			(<a href="viewMembers.htm?orgId=${ org.orgId }">ViewMembers</a>) 
					    			<sec:authorize access="hasRole('ROLE_ADMIN')">
					    				(<a href="deleteOrg.htm?orgId=${ org.orgId }">Delete</a>)
					    			</sec:authorize>
					    		</li>
					    	</c:forEach>
					    </ul>
					    <div id="orgReport">
							<a href="jasper/report/org/download">Download Report</a>
						</div>
					</c:when>
				</c:choose>
				
				<hr />
				
				<h4>Existing Organizations (using displaytag): </h4>
				<s:url id="thisUrl"/>
				<display:table 
				 id="item" 
				 name="${orgList}" 
				 requestURI="${thisUrl}" 
				 pagesize="2" 
				 sort="list" >
					<display:column property="orgId" title="ID" sortable="true" />
					<display:column property="orgName" title="Name" sortable="true" />
					<display:column title="Action">View ${item.orgId}</display:column>
				</display:table>
				
			
				<hr />

				<h4>Existing Organizations (using displaytag & jquery-tablesorter): </h4>
				<display:table 
				 id="myTable" 
				 name="${orgList}" 
				 class="tablesorter" >
					<display:column property="orgId" title="ID" />
					<display:column property="orgName" title="Name" />
					<display:column title="Action">View ${myTable.orgId}</display:column>
				</display:table>
				 	<div id="pager" class="pager">
						<form>
							<img src="js/jquery.tablesorter/addons/pager/icons/first.png" class="first"/>
							<img src="js/jquery.tablesorter/addons/pager/icons/prev.png" class="prev"/>
							<input type="text" class="pagedisplay"/>
							<img src="js/jquery.tablesorter/addons/pager/icons/next.png" class="next"/>
							<img src="js/jquery.tablesorter/addons/pager/icons/last.png" class="last"/>
							items per page:
							<select class="pagesize">
								<option selected="selected"  value="10">10</option>
								<option value="20">20</option>
								<option value="30">30</option>
								<option  value="40">40</option>
							</select>
						</form>
					</div>

				 
				 	
				
			</div>
		</section>
		<aside>
		</aside>
		<footer>
		</footer>
	</div>
	

	
</body>
</html>