<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:choose>
	<c:when test="${ flag != 'org' }">
		<c:choose>
			<c:when test="${ flag != 'hideSug' }">
				<c:choose>
					<c:when test="${fn:length(userList) > 0}">
				   		<c:forEach items="${userList}" var="user" varStatus="i">
				    		<li><a>${ user.firstName } ${ user.mi }. ${ user.lastName }<c:if test="${ flag == 'address' }"> : ${ user.homeAddress }</c:if></a></li>
				    	</c:forEach>
					</c:when>
					<c:otherwise>
						<li><a>No Results</a></li>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<li><a>No suggestions for this category</a></li>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${fn:length(orgList) > 0}">
		   		<c:forEach items="${orgList}" var="org" varStatus="i">
		    		<li><a>${ org.orgName }</a></li>
		    	</c:forEach>
			</c:when>
			<c:otherwise>
				<li><a>No Results</a></li>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>
	