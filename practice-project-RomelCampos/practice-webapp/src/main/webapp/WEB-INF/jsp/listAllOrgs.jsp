<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
<!--
	$(function(){
		$('.hide').hide();
		$('input.join').click(function(){
			var tmp = $(this);
			tmp.parent().parent().css('border', 'solid 1px');
			//tmp.parent().parent().css('background-color', '#dddddd');
			var orgId = $(this).next().val();
			var userId = $('#userId').val();
			$.ajax({
		    	url: 'userJoinOrg.htm',
		    	data: ({userID : userId, orgID : orgId}),
		    	success: function(data) {
		    		tmp.parent().next().next().load('viewMembers.htm', { orgID : orgId });
		    		tmp.parent().next().html('<hr />'+data).show().fadeOut(3000);
		    		//$('div#result').text(data).show().fadeOut(3000);
		    	},
		    	error: function(){
		    		$(this).val('Ajax Failed');
		    	}
			});
		});
		
		/* $('.members').toggle(function() {
			$(this).parent().next().next().load('viewMembers.htm', { orgID : $(this).next().next().val() });
		}, function() {
			$(this).parent().next().next().html("");
		});  */
		
		$('.members').click(function(){
			var tmp = $(this);
			if($(this).parent().next().next().html() == ""){
				tmp.parent().parent().css('border', 'solid 1px');
				$(this).parent().next().next().load('viewMembers.htm', { orgID : $(this).next().next().val() });
			}
			else{
				tmp.parent().parent().css('border', '');
				$(this).parent().next().next().html("");
			}
		}); 
	});
	
	function showButtons(x){
		$('li#'+ x).css('background-color', '#E0E0E0');
		$('li#'+ x +' span').toggleClass("active").show();
	}
	function hideButtons(x){
		//$('li#'+ x+' span.blank').html('');
		$('li#'+ x).css('background-color', '#fff');
		$('li#'+ x +' span.hide').toggleClass("active").hide();
	}
//-->
</script>

<input type="hidden" value="${ userId }" id="userId"/>
<div id="result"></div>
<c:choose>
	<c:when test="${fn:length(orgList) > 0}">
		<div style="width: 260px">
	   		<ul>
		   		<c:forEach items="${orgList}" var="org" varStatus="i">
		    		<li id="${ i.count }" onmouseover="showButtons(this.id)" onmouseout="hideButtons(this.id)" style="padding: 10px">
	    				${ org.orgName }
		    			<span class="hide" style="float: right; margin-top: -6px">
		    				<input type="button" class="members" value="members" />
		    				<input type="button" class="join" value="join" />
		    				<input type="hidden" value="${ org.orgId }"/>
		    			</span>
		    			<div style="color: #8E2323"></div>
		    			<span class="blank"></span>
		    			<%-- <ul id="reload">
		    				<c:forEach items="${org.members}" var="user" varStatus="i">
		    					<li>${ user.firstName }</li>
		    				</c:forEach>
		    			</ul> --%>
		    		</li>
		    	</c:forEach>
	    	</ul>
		</div>
	</c:when>
	<c:otherwise>
	    <p>Wala pay organisasyon!</p>
	</c:otherwise>
</c:choose>