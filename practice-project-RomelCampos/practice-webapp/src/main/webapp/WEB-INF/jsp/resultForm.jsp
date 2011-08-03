<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>
	div p{
		margin-bottom: 10px
	}
</style>
<hr />
<c:choose>
	<c:when test="${ flag != 'notFound' }">
		<div id="userInfo" style="padding: 20px; font-size: 14px">
			<c:choose>
				<c:when test="${ org == null }">
					<p><b>Name:</b> ${ user.fullName } </p>
					<p><b>Email:</b> ${ user.emailAddress } </p>
					<p><b>Gender:</b> ${ user.gender } </p>
					<p><b>Birthday:</b> ${ user.birthDate } </p> 
					<p><b>Home:</b> ${ user.homeAddress } </p>
					<p><b>Contact Number:</b> ${ user.contactNumber } </p>
				</c:when>
				<c:otherwise>
					<p><b>Org Name:</b> ${ org.orgName } </p>
					<p><b>Member(s):</b> 
						<c:forEach items="${org.members}" var="user" varStatus="i">
				    		<p style="text-indent: 40px">${ user.fullName }</p>
				    	</c:forEach>
				    </p>
				</c:otherwise>
			</c:choose>
		</div>
	</c:when>
	<c:otherwise>
		<div style="border: solid 2px #a3afcc; padding: 13px; text-align: center; background-color: #5274cc; color: white; font-weight: bold">No match found.</div>
	</c:otherwise>
</c:choose>