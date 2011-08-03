<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
	$('#close').click(function(){
		
		$('#watever').html('');
	});
</script>
<div id="watever">
	<div id="wrapper" class="ambot">
		<span style="text-align: right; margin-top: -2px">
			<a id="close">close</a>
		</span>
		<c:choose>
			<c:when test="${fn:length(orgList) > 0}">
			    <h4>Organizations: </h4>
			    <ul>
			   		<c:forEach items="${orgList}" var="org" varStatus="i">
			    		<li><a href="viewMembers.htm">${ org.orgName }</a></li>
			    	</c:forEach>
			    </ul>
			    <p>Ganahan pa ka mo-apil ug lain nga organisasiyon? Pislita <a href="manageOrgs.htm">ni</a>.</p>
			</c:when>
			<c:otherwise>
			    <p>Wala kay organisasyon nga gi-apilan! 
			    Pislita <a href="manageOrgs.htm">ni</a> para mu-apil.</p>
			</c:otherwise>
		</c:choose>
	</div>
</div>