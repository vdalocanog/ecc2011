<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/org.css" media="screen" />
<script>
	$(function(){
		$('form').hide();
		//loadList();
		var loadingIcon = "<img src='resources/images/ajax-loader.gif' width='15px' height='15px' />";
		var checkIcon = "<img src='resources/images/check.png' width='15px' height='15px' />";
		var wrongIcon = "<img src='resources/images/wrong.png' width='15px' height='15px' />";
		var loadingIcon3 = "<img src='resources/images/loading2.gif' width='50spx' height='12px' />";
		var loadingIcon2 = "<img src='resources/images/loading1.gif' />";
		
		function loadList(){
			$('#listOrgs').html(loadingIcon2);
			$('#listOrgs').load('listAllOrgs.htm');
		}
		
		$("form").submit(function() {
			$("#result").html(loadingIcon3);
			$.ajax({
		    	url: 'addOrg.htm',
		    	data: ({orgName: $('#orgName').val()}),
		    	success: function(data) {
		    		$('#orgName').val('');
		    		$("#result").html(data).show().fadeOut(3000);
		    		if($('#xaka').text() == 'Hide organizations') loadList();
		    	},
		    	error: function(){
		    		$("#result").html("Ajax Failed.");
		    	}
			});
		    return false;
		});
		
		$('#orgName').keyup(function(e){
			if(e.keyCode != 13){
				$("#result").html(loadingIcon);
				$.ajax({
			    	url: 'checkOname.htm',
			    	data: ({orgName: $('#orgName').val()}),
			    	success: function(data) {
			    		if(data == 'isOk') $("#result").html(checkIcon);
			    		else $("#result").html(wrongIcon);
			    	},
			    	error: function(){
			    		$("#result").html("Ajax Failed.");
			    	}
				});
			}
		});
		
		$('h2 a#xaka').toggle(function() {
			loadList();
			$(this).text("Hide organizations");
		}, function() {
			$('#listOrgs').html('');
			$(this).text("Show all organizations");
		});
		
		$('#create').click(function(){
			$('form').show();
		});
		
		$('#hide').click(function(){
			$('form').hide();
		});
	});
</script>
<style>
<!--
	span input {
		border: solid 2px black;
	}
-->
</style>
</head>
<body>
	<div id="wrapper" style="margin-top: -160">
		<h1>Organizations</h1>
		<hr />
		<h2><a href="#" id="create">Create Organization</a></h2>
		<form method="POST">
			<!-- <label for="orgName">Name of organizaion</label> <br />  -->
			<input type="text" id="orgName" placeholder="Name of organizaion"/>
			<input type="submit" value="Create" />
			<input type="button" value="Hide" id="hide"/>
			<span id="result" style="color: green"></span>
		</form>
		<hr />
		<h2><a href="#" id="xaka">Show all organizations</a></h2>
		<div id="listOrgs"></div>
		<a href="home.htm"><input class="me" type="button" value="<<back"/></a>
	</div>
</body>
</html>