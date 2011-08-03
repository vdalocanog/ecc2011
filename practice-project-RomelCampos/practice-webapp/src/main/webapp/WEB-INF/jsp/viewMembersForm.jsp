<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
<!--

-->
</script>

<hr  style="padding-top: 3px" />
<c:choose>
	<c:when test="${fn:length(orgMembers) > 0}">
		<ul>
	   	<c:forEach items="${orgMembers}" var="user" varStatus="i">
	   		<li>${ user.firstName } ${ user.mi }. ${ user.lastName } (${ user.userName })</li>
	   	</c:forEach>
	   	</ul>
	   	<!-- <div id="orgReport">
			<a href="jasper/report/download">Download Report</a>
		</div> -->
	</c:when>
	<c:otherwise>
	    <ul><li>Walay membro.</li></ul>
	</c:otherwise>
</c:choose>
