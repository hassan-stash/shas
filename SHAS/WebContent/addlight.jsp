<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.sql.*,javax.servlet.*" errorPage=""
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Lights</title>
<link href='http://fonts.googleapis.com/css?family=Wendy+One'
	rel='stylesheet' type='text/css'>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/timepicker.js"></script>
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

function validate()
	{
	var table=document.getElementById("room");
	var cells=table.getElementsByTagName("td");
	for(var i=0;i<cells.length;i++)
		{
		if(i==1)
			{
			if(cells[1].childNodes[1].value=="99")
				{
				alert("Please Select a Room");
				return false;
				}
			}
		if(i==3)
			{
			if(cells[3].childNodes[0].value=="")
				{
				alert("Please Enter the Device Name");
				return false;
				}
			}
		if(i==5)
			{
			if (((cells[5].childNodes[1].checked==false) && (cells[5].childNodes[3].checked==false))== "1")
			{
				alert("Please Select Slider or ON/OFF");
				return false;
			}
			}
				
				
			
		}
	}


	
</script>
<style type="text/css">
input {
border: 1px solid #FAB066;
-webkit-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
-moz-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
padding: 15px;
background: rgba(255, 255, 255, 0.5);
margin: 0 0 10px 0;
}
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

#topmenu ul {
float: left;
top: 15px;
padding: 0;
text-align: center;
width: auto;
}

ul {
list-style: none outside none;
}

#topmenu li {
list-style-type: none;
padding-left: 38px;
padding-right: 38px;
display: inline;
height: 22px;
text-align: center;
width: auto;
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

#topmenu {
display: block;
float: left;
position: relative;
color: white;
height: 30px;
width: 800px;
left: 50px;
}

#welcomeName {
color: white;
float: right;
position: relative;
top: 15px;
right: 30px;
padding-right: 2px;
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

#logo {
color: #ffffff;
font-family: 'Wendy One', sans-serif;
font-size: 45px;
position: relative;
left: 30px;
float: left;
}

footer {
position: relative;
text-align: right;
width: 800px;
background-color: white;
display: block;
top: 559px;
height: 20px;
font-size: 14px;
}

section {
position: relative;
display: block;
top: 15px;
left: 18px;
}

#content {
float: left;
width: 800px;
}
#main { 
    width: 900px;
    margin: 0 auto;
}
#statusdiv    {
    width: 350px;
    height: 400px;    
    float: left;
}

#leveldiv  {
    width: 350px;    
    height: 400px;
    float: right;
    
}

article {
position: relative;
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
height: 280px;
width: 407px
}

button {
height: 40px;
width: 70px;
background-color: #DDDDDD;
border: 1px solid #BBBBBB;
border-radius: 3px 3px 3px 3px;
box-shadow: 0 1px 0 rgba(0, 0, 0, 0.3), 0 2px 2px -1px
rgba(0, 0, 0, 0.5), 0 1px 0 rgba(255, 255, 255, 0.3) inset;
color: #555555;
cursor: pointer;
font: bold 13px arial, helvetica, sans-serif;
text-shadow: 0 1px 0 rgba(255, 255, 255, 0.9);
position: relative;
margin-left: 30px;
padding: 2px;
}

button:hover {
background-color: #EEEEEE;
color: #555555;
}

#sprinkbtn {
left: 65px;
background-color: lightgreen;
}

#thermobtn {
left: 49px;
background-color: ff3300;
}

#lightbtn {
left: 72px;
background-color: ff3300;
}

.status {
position: relative;
margin-left: 15px;
text-align: left;
padding: 5px;
}

#devstatustab {
position: relative;
background: #4c4c4c; /* Old browsers */
background: -moz-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%, #1c1c1c
91%, #131313 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(12%, #4c4c4c),
color-stop(51%, #111111), color-stop(76%, #2b2b2b),
color-stop(91%, #1c1c1c), color-stop(100%, #131313) );
/* Chrome,Safari4+ */
background: -webkit-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%,
#1c1c1c 91%, #131313 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%, #1c1c1c
91%, #131313 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%, #1c1c1c
91%, #131313 100%); /* IE10+ */
background: linear-gradient(to bottom, #4c4c4c 12%, #111111 51%, #2b2b2b 76%,
#1c1c1c 91%, #131313 100%); /* W3C */
filter: progid : DXImageTransform.Microsoft.gradient (   startColorstr =
'#4c4c4c', endColorstr = '#131313', GradientType = 0 ); /* IE6-9 */
width: 100%;
height: 20px;
color: white;
text-align: center;
}
.inputstatus{
border: 1px solid #FAB066;
-webkit-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
-moz-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
padding: 15px;
background: rgba(255, 255, 255, 0.5);
margin: 0 0 10px 0;
height: 10px;
width: 105px
}
.Onstatus{
border: 1px solid #FAB066;
-webkit-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
-moz-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
padding: 15px;
background: rgba(255, 255, 255, 0.5);
margin: 0 0 10px 0;
height: 10px;
width: 50px;
background-color: #008000
}
.Offstatus{
border: 1px solid #FAB066;
-webkit-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
-moz-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px
rgba(0, 0, 0, 0.1);
padding: 15px;
background: rgba(255, 255, 255, 0.5);
margin: 0 0 10px 0;
height: 10px;
width: 50px;
background-color: #F4084F
}

</style>

</head>
<body>
<div id="header">
<div id="logo">SHAS</div>
<div id="logout"><a href="LogoutPage.jsp">Logout</a></div>
<!-- end of logout div -->
<div id="welcomeName">
<%
	
%>
</div>
<!-- end of welcomeName --></div>
<!-- end of header -->
<aside>
<nav>
<ul id="menu">
	<li><a href="home.jsp">Home</a></li>
	<li><a href="#" class="expandable">Devices</a>
	<ul style="display: none;">
		<li><a href="SprinklerGUI.jsp">Sprinkler</a></li>		
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
	<li><a href="#">About</a></li>
	<li><a href="#">Contact</a></li>
</ul>
</nav>
</aside>
<h1>Add Light Device</h1>
<form name="frmaddlight" action="doaddLight.jsp" method="post" onSubmit="return validate();">
<table height="100" width="500" align="center" id="room">
<tr>
<td>Room List</td>
<td>
<select name="roomlist" onchange="showState(this.value)">  
  <option value="99">Select</option>  
 <%
 try 
 {
 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");  
 String sqlOption="select distinct rooms from roomie";
 PreparedStatement psLight=null;
 
 psLight=con.prepareStatement(sqlOption);
 ResultSet rsLight = null;
 
 rsLight=psLight.executeQuery();
 while(rsLight.next()){
     %>
 <option value="<%=rsLight.getString(1)%>"><%=rsLight.getString(1)%></option>  
 <%
 }
 if(psLight!=null)
	 psLight.close();
 
 if(rsLight!=null)
	 rsLight.close();
 }
 catch(Exception e)
 {
	 e.printStackTrace();
 }
     %>
     </select>
       </td>
 
</tr>
<tr>
<td>Device Name:</td>
<td><input type="text" name="txtDeviceName"></td>
</tr>
<tr>
<td>Button Type</td>
<td>
<input type="radio" value="1" name="select1">Slider
<input type="radio" value="0" name="select1">ON/OFF
</td>
</tr>
<tr>
<td>Conditions</td>
<td><select name="roomcondition">
<option value="0">OFF</option>
<option value=3>Dim</option>
<option value="1">Natural</option>
<option value="2">Read</option>

</select></td>

</tr>
<tr>
<td><input type ="submit" value="Add Device"></td>
<td><input type="reset" value="CANCEL" onclick="history.back()"></td>
</tr>
</table>

<span type="text" id="lblMessage" name="lblMessage" class="color-red">&copy Design and Code by Team Omega</span>
</form>
</body>
</html>