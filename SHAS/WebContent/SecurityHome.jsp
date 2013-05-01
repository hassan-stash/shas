<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<% 

if(session.getAttribute("sUserID") == null)

response.sendRedirect("Invalid.jsp?error="+"invalid access");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link href='http://fonts.googleapis.com/css?family=Wendy+One'
	rel='stylesheet' type='text/css'>
<title>SecurityHomePage</title>
<link href='http://fonts.googleapis.com/css?family=Wendy+One'
	rel='stylesheet' type='text/css'>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function initMenu() {
		$('#menu ul').hide(); // Hide the submenu
		if ($('#menu li').has('ul'))
			$('#menu ul').prev().addClass('expandable'); // Expand/collapse a submenu when it exists  
		$('.expandable').click(function() {
			$(this).next().slideToggle();
			$(this).toggleClass('expanded');
		});
	}

	// When document ready, call initMenu() function 
	$(document).ready(function() {
		initMenu();
	});
</script>

<style type="text/css">
body {
	background: #eee
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAMAAAC6sdbXAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAZQTFRF3d3d////riJKgAAAAAJ0Uk5T/wDltzBKAAAAFUlEQVR42mJgBAEGGMmAxAYCgAADAAGGABmnk/7aAAAAAElFTkSuQmCC);
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
	margin: 0;
	padding: 0;
}

#header {
	background: none repeat scroll 0 0 #000000;
	height: 50px;
	width: 100%;
	top: 15px;
}

#logout {
	float: right;
	position: relative;
	top: 15px;
	padding-right: 25px;
}

a {
	color: #E56A22;
}

#welcomeName {
	color: white;
	float: right;
	position: relative;
	top: 15px;
	right: 30px;
	padding-right: 2px;
}

#logo {
	color: #ffffff;
	font-family: 'Wendy One', sans-serif;
	font-size: 45px;
	position: relative;
	left: 30px;
	float: left;
}

.lName {
	position: relative;
	margin: 0px;
	padding: 0px;
	display: inline-block;
	width: 145px;
}

.lCode {
	position: relative;
	margin: 0px;
	display: inline-block;
	padding: 0px;
	width: 50px;
}

aside {
	float: left;
	margin-right: 20px;
	width: 250px;
	display: block;
}

nav {
	display: block;
}

div#notification {
	position: relative;
	padding: 10px;
	margin-left: 10px;
}

input[type="radio"] {
	position: relative;
	display: inline-block;
	margin: 5px;
}

#windowContainer {
	position: relative;
	width: 500px;
	padding: 20px;
	top: 15px;
	margin: 0 0 20px 0;
	text-align: left;
	background: #fff;
	-moz-box-shadow: 0 1px 1px #999;
	-webkit-box-shadow: 0 1px 1px #999;
	box-shadow: 0 1px 1px #999;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

#doorContainer {
	position: relative;
	width: 500px;
	padding: 20px;
	top: 15px;
	margin: 0 0 20px 0;
	text-align: left;
	background: #fff;
	-moz-box-shadow: 0 1px 1px #999;
	-webkit-box-shadow: 0 1px 1px #999;
	box-shadow: 0 1px 1px #999;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

.divClass {
	position: relative;
	padding-top: 10px;
}

#notification {
	background: none repeat scroll 0 0 #FFFFFF;
	border-radius: 5px 5px 5px 5px;
	box-shadow: 0 1px 1px #999999;
	float: left;
	margin: 0 0 20px;
	padding: 5px;
	position: relative;
	text-align: left;
	top: 15px;
	width: 400px;
}

#MainContainer {
	float: left;
	position: relative;
}

/* Vertical menu */
#menu {
	display: block;
}

#menu ul {
	position: relative;
	padding: 0;
}

#menu li {
	margin: 0 0 3px 0;
}

#menu a {
	display: block;
	*display: inline-block;
	*width: 240px;
	text-decoration: none;
	background: #ddd;
	color: #444;
	padding: 10px 5px;
	text-transform: uppercase;
	font: bold 14px Arial, Helvetica, sans-serif;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	-moz-box-shadow: 0 1px 0 #ccc;
	-webkit-box-shadow: 0 1px 0 #ccc;
	box-shadow: 0 1px 0 #ccc;
}

#menu a:hover {
	color: #eee;
	background: #9c9c9c;
	background: -webkit-gradient(linear, left top, left bottom, from(#bbb),
		to(#999) );
	background: -webkit-linear-gradient(top, #bbb, #999);
	background: -moz-linear-gradient(top, #bbb, #999);
	background: -ms-linear-gradient(top, #bbb, #999);
	background: -o-linear-gradient(top, #bbb, #999);
	background: linear-gradient(top, #bbb, #999);
}

#menu .expandable {
	position: relative;
}

#menu .expandable:before,#menu .expandable:after {
	content: '';
	position: absolute;
	right: 5px;
	margin-top: 5px;
	border-top: 6px solid #444;
	border-right: 6px solid transparent;
	border-left: 6px solid transparent;
}

#menu .expandable:before {
	border-top-color: #fff;
	margin-top: 6px;
}

#menu .expanded:after {
	border-top: 0;
	border-bottom: 6px solid #444;
}

#menu .expanded:before {
	border-top: 0;
	border-bottom: 6px solid #fff;
}

#menu ul a {
	background: #f2f2f2;
	text-transform: none;
	font-weight: normal;
}

#menu ul a:hover {
	background: #fafafa;
	color: #444;
}

ul {
	list-style: none outside none;
}

button {
	position: relative;
	width: 85px;
	height: 45px;
	background-color: #FFFFFF;
	border: 1px solid #BBBBBB;
	border-radius: 3px 3px 3px 3px;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.3), 0 2px 2px -1px
		rgba(0, 0, 0, 0.5), 0 1px 0 rgba(255, 255, 255, 0.3) inset;
	color: #555555;
	cursor: pointer;
	font: bold 13px arial, helvetica, sans-serif;
	text-shadow: 0 1px 0 rgba(255, 255, 255, 0.9);
	position: relative;
	margin-left: 1px;
	padding-bottom: 5px;
}

button:hover {
	background-color: lightgrey;
	color: #555555;
}
</style>

<script type="text/javascript">
	
	var doorNames = [ "MainFrontDoor", "GarageDoor", "HouseGarageDoor",
			"PatioDoor" ];
	var windowNames = [ "frontWindow", "backWindow", "leftWindow",
			"rightWindow", "skyLights" ];
	var windowCodes = [ "100", "200", "300", "400", "500" ];

	function displayDoors() {
		var getDiv = document.getElementById('doorContainer');

		for ( var i = 0; i < doorNames.length; i++) {
			getDiv.innerHTML += "<div class='divClass' id=row" + (i + 1)
					+ "><label class='lName'>" + doorNames[i]
					+ "</label><label class='lCode'>" + (i + 1)
					+ "</label><input id=open" + (i + 1) + " value=" + (i + 1)
					+ " type='radio' onclick=alarm(); name=dstatus" + (i + 1)
					+ ">OPEN<input id=closed" + (i + 1)
					+ " type='radio' checked='checked' name=dstatus" + (i + 1)
					+ ">CLOSED</div>"
		}
		var getBtnId = document.getElementById('viewDoors');
		getBtnId.disabled = true;
		getBtnId.style.color = 'lightgrey';
	} //end of displayDoors

	function displayWindows() {
		var getDiv = document.getElementById('windowContainer');

		for ( var i = 0; i < windowNames.length; i++) {
			getDiv.innerHTML += "<div class='divClass' id=wind" + (i + 1)
					+ "><label class='lName'>" + windowNames[i]
					+ "</label><label class='lCode'>" + windowCodes[i]
					+ "</label><input id=open" + (i + 1) + " value=" + (i + 1)
					+ " type='radio' onclick=alarm(); name=wstatus" + (i + 1)
					+ ">OPEN<input id=closed" + (i + 1)
					+ " type='radio' checked='checked' name=wstatus" + (i + 1)
					+ ">CLOSED</div>"
		}
		var getBtnId = document.getElementById('viewWindows');
		getBtnId.disabled = true;
		getBtnId.style.color = 'lightgrey';
	} //end of displayWindows

	var userInput; //global
	var call = document.createElement("div");
	call.id = "policeCall";
	var timerFlag;
	var handle;
	/*for(var ctr=0;ctr<doorNames.length;ctr++)
	 {
	 timerFlag[ctr]=0;
	 }
	 var handle=[]; //array for handling clearTimeouts
	 */

	function alarm() {
		handle = setTimeout("policeCall();", 5000);
		//alert(handle);
		userInput = confirm("Press OK to Cancel Alarm");
		var getDiv = document.getElementById('notification');

		if (userInput == true) {
			clearTimeout(handle);
			//alert(handle);
			call.innerHTML = "Alarm switched Off Successfully on"
					+ new Date()
					+ "<div><button type='button' onclick='Clear()'>Clear Notification</button></div>";
			call.style.cssText = "color:red;";
			getDiv.appendChild(call);
			//timerFlag = 0;
			//setTimeout(function(){call.innerHTML = "";},3000);

		}

		/* else if (userInput == false)
		 {
		 handle = null;
		 policecall();
		 } */

	}

	function policeCall() {
		if (userInput == false || userInput == null || handle == null) {
			call.innerHTML = "Calling Police...."
					+ new Date()
					+ "<div><button type='button' onclick='Clear()'>Clear Notification</button></div>";
			call.style.cssText = "color:green;";
			var getDiv = document.getElementById('notification');
			getDiv.appendChild(call);
			//setTimeout(function(){call.innerHTML = "";},3000);

		}

	}

	function Clear() {
		call.innerHTML = "";
	}
</script>
</head>
<body>
<div id="header">
<div id="logo">SHAS</div>
<div id="logout"><a href="LogoutPage.jsp">Logout</a></div>
<!-- end of logout div -->
<div id="welcomeName">
<%
	out.print(" " + session.getAttribute("sUserID"));
%>
</div>
<!-- end of welcomeName --></div>
<!-- end of header -->
<aside>
<nav>
<ul id="menu">
	<li><a href="success.jsp">Home</a></li>
	<li><a href="#" class="expandable">Devices</a>
	<ul style="display: none;">
		<li><a href="#">Sprinkler</a></li>
		<li><a href="light.jsp">Lighting</a></li>
		<li><a href="SecurityHome.jsp">Security</a></li>
	</ul>
	</li>
	<li><a href="#" class="expandable">Usage Reports</a>
	<ul style="display: none;">
		<li><a href="Report.jsp">Power usage</a></li>
		<li><a href="Wreport.jsp">Water usage</a></li>
	</ul>
	</li>
	<li><a href="aboutus.jsp">About</a></li>
	<li><a href="contact.jsp">Contact</a></li>
</ul>
</nav>
</aside>

<div id="MainContainer">
<div id="doorContainer">
<button id="viewDoors" onclick="displayDoors()">View All Doors</button>
</div>
<div id="windowContainer">
<button id="viewWindows" onclick="displayWindows()">View All
Windows</button>
</div>
</div>
<div id="notification">
<div style="position: "relative; padding-bottom: 5px;}>Notification
Box</div>
</div>


</body>
</html>