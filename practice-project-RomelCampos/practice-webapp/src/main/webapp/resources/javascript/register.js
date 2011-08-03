/**
 * 
 */

$(function() {
	/*$('#uname').focus();*/
	
	var loadingIcon = "<img src='../resources/images/ajax-loader.gif' width='15px' height='15px' />";
	var checkIcon = "<img src='../resources/images/check.png' width='15px' height='15px' />";
	var wrongIcon = "<img src='../resources/images/wrong.png' width='15px' height='15px' />";
	
	$('#uname').keyup(function() {
		$('#userNameMessage').html(loadingIcon);
		$.ajax({
	    	url: 'checkUname.htm',
	    	data: ({uname : $('#uname').val()}),
	    	success: function(data) {
	    		var status = wrongIcon; 
	    		if(data == "") status = checkIcon;
	    		$('#userNameMessage').html(status + " <span class='mismatch'>" + data + "</span>");
	    	},
	    	error: function(){
	    		$('#userNameMessage').html("Ajax Failed.");
	    	}
		});
	});
	
	$('#pword').blur(function(){
		$('#pwordmsg').html(loadingIcon);
		var size = $('#pword').val().length;
		if(size < 4) $('#pwordmsg').html(wrongIcon + " <span class='mismatch'>too short</span>");
		if(size > 3 && size < 8) $('#pwordmsg').html(checkIcon +" <span id='weak'>weak</span>");
		if(size > 7 && size < 16) $('#pwordmsg').html(checkIcon +" <span id='moderate'>moderate</span>");
		if(size > 15) $('#pwordmsg').html(checkIcon +" <span id='strong'>strong</span>");
	});
	
	$('#pword2').blur(function(){
		$('#pword2msg').html(loadingIcon);
		if($('#pword2').val() != "" && $('#pword').val() == $('#pword2').val()) $('#pword2msg').html(checkIcon +" <span id='confirmed'>confirmed</span>");
		else $('#pword2msg').html(wrongIcon +" <span class='mismatch'>password mismatch</span>");
	});
	
	$(".numberOnly").keydown(function (event) { 
		if ((!event.shiftKey && !event.ctrlKey && !event.altKey) && ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105))){ // 0-9 or numpad 0-9, disallow shift, ctrl, and alt  
			// check textbox value now and tab over if necessary 
		} 
		else if (event.keyCode != 8 && event.keyCode != 46 && event.keyCode != 37 && event.keyCode != 39 && event.keyCode != 9 && event.keyCode != 13){ // not esc, del, left or right , enter 
			event.preventDefault(); 
		} 
			// else the key should be handled normally 
	}); 
	
}); 