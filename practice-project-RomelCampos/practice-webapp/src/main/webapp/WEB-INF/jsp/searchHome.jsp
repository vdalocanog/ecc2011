<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Search</title>
<link rel="stylesheet" type="text/css" href="../resources/css/general.css" media="screen" />
<link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<style>
<!--
/* 	body{
		margin:0; 
		padding:0; 
		height:100%
	} */
	#select{
		padding: 20px;
		text-align: center;
		font-family: helvetica; 
		font-size: 16px; 
		margin-left: auto ;
  		margin-right: auto ;
  		margin-top: 30px;
  		width: 270px;
  		border:1px solid gray;
		-moz-box-shadow: 10px 10px 5px #888;
		-webkit-box-shadow: 10px 10px 5px #888;
		box-shadow: 10px 10px 5px #888;
		-webkit-border-radius: 10px; 
		-moz-border-radius: 10px; 
		border-radius: 10px; 	
	}
	
	a:link			{color: #F06;text-decoration: none;}
	a:visited 		{text-decoration: none;color: #F06;}
	a:hover 		{text-decoration: underline;color: #09F;}
	a:active		{text-decoration: none;color: #09F;}
	
	#close{
		font-size:14px;
		line-height:14px;
		/* right:6px;
		top:4px; */
		color:#6fa5fd;
		font-weight:700;
		display:block;
		text-align: right;
		margin-top: -12px;
		margin-bottom: 10px;
	}
-->
</style>
<script type="text/javascript" src="../js/jquery-ui-1.8.14.custom/js/jquery-1.5.1.min.js"></script>
<script src="../resources/javascript/popup.js" type="text/javascript"></script>
<script>
	$(function(){
		$("select").change(function(){
			$("#searchUser").focus();
		});
	});
</script>
<script type="text/javascript" src="../resources/javascript/jquery.ausu-autosuggest.min.js"></script>
<script>
$(document).ready(function() {
    $.fn.autosugguest({  
           className: 'ausu-suggest',
          	methodType: 'GET',
            minChars: 2,
            rtnIDs: false,
            dataFile: 'data.htm'
    });
});
</script>
</head>
<body>
	<div id="select">
		<a id="close" href="../home.htm">...back</a>
		<font color="maroon"><b>Search: </b></font>
		<input id="button" type="button" value="User" />
		<input id="button2" type="button" value="Org" />
	</div>
	<div id="popupContact">
		<a id="popupContactClose">x</a>
		<h1></h1>
		<form id="form">
			<span id="user" style="float: left; margin-top: 2px">
				<font color=maroon><b>Search by: </b></font>
				<select id="cat">
					<option value="Name">Name</option>
					<option value="Address">Address</option>
					<option value="emailAddress">Email</option>
					<option value="userName">Username</option>
				</select>
			</span>
			<div class="ausu-suggest">
				<input id="searchUser" type="text" AUTOFOCUS="AUTOFOCUS" autocomplete="off"/>
			</div>
			<div class="ausu-suggest">
				<input id="searchOrg" type="text" AUTOFOCUS="AUTOFOCUS" autocomplete="off"/>
				<input type="submit" value="find"/>
			</div>
			<br /><br />
			<!-- <hr style="clear: both"/> -->
			<div id="result">
				<div id="loader" style="padding: 90px; text-align: center"></div>
			</div>
		</form>
	</div>
	<div id="backgroundPopup"></div>
</body>
</html>