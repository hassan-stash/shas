<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.sql.*" errorPage="" %>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]> <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]> <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.*,java.text.*" errorPage="" %>
<% 

if(session.getAttribute("sUserID") == null)

response.sendRedirect("Invalid.jsp?error="+"invalid access");

%>
<head>
<title>SHAS Light</title>
<link href='http://fonts.googleapis.com/css?family=Wendy+One'
	rel='stylesheet' type='text/css'>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="js/timepicker.js"></script>
<script type="text/javascript">
function validate()
{
	alert("Automated Successfully");
	}

</script>
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
<script type="text/javascript" language="javascript">
window.onload= lightSensor(<% request.getParameter("simulate"); %>)
    <%

 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
 
 %> 
function lightSensor(values)
{
	
var table=document.getElementById("room");
var cells=table.getElementsByTagName("td");
var checked=null;
for (var i=0;i<cells.length;i++)
	{
		if(i%2!=0){
		if((cells[i].childNodes[0].attributes[0].value)!="range")
		{
		for(var j=0;j<3;j++)
		{
		if(j%2==0)
		{
if(values>20)
cells[i].childNodes[2].checked=true;

else
	cells[i].childNodes[0].checked=true;
}
}
}
else
{
cells[i].firstChild.value= 100-values;
}
}
	}
}
function rooms(selected)
{
	
	var table=document.getElementById("room");
	var cells=table.getElementsByTagName("td");
	for(var i=0;i<cells.length;i++)
		{
		if((cells[i].className)!=selected)
			{
			cells[i].hidden=true;
			}
		else
			{
			cells[i].hidden=false;
			}
		if(selected=="All Rooms")
			{
			cells[i].hidden=false;
			}
		}


}
function optionChange(selectObj)
{
var x= selectObj;
var table=document.getElementById("room");
var cells=table.getElementsByTagName("td");
switch(true)
{
case (x==0)://off
for (var i=0;i<cells.length;i++)
	{
		if(i%2!=0){
		if((cells[i].childNodes[0].attributes[0].value)!="range")
		{
		for(var j=0;j<3;j++)
		{
		if(j%2==0)
		{
if(cells[i].childNodes[j].checked==true)
cells[i].childNodes[2].checked=true;
}
}
}
else
{
cells[i].firstChild.value= "0";
}
}
}
break;
case (x==1)://natural
{
for (var i=0;i<cells.length;i++)
{
if(i%2!=0){
if((cells[i].childNodes[0].attributes[0].value)!="range")
{
for(var j=0;j<3;j++)
{
if(j%2==0)
{
if(cells[i].childNodes[j].checked==true)
cells[i].childNodes[2].checked=true;
}
}
}
else
{
cells[i].firstChild.value= "25";
}
}
}
break;
}
case (x==2)://read
for (var i=0;i<cells.length;i++)
{
if(i%2!=0){
if((cells[i].childNodes[0].attributes[0].value)!="range")
{
for(var j=0;j<3;j++)
{
if(j%2==0)
{
if(cells[i].childNodes[j].checked==false)
cells[i].childNodes[0].checked=true;
}
}
}
else
{
cells[i].firstChild.value= "75";
}
}
}
break;
case (x==3)://Dim
{
for (var i=0;i<cells.length;i++)
{
if(i%2!=0){
if((cells[i].childNodes[0].attributes[0].value)!="range")
{
for(var j=0;j<3;j++)
{
if(j%2==0)
{
if(cells[i].childNodes[j].checked==true)
cells[i].childNodes[2].checked=true;
}
}
}
else
{
cells[i].firstChild.value= "12";
}
}
}
break;
}
default:
//alert("Default");
break;
}
}
</script>
<style type="text/css">
input [type="submit"] {
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
		<li><a href="#">Power usage</a></li>
		<li><a href="Wreport.jsp">Water usage</a></li>		
	</ul>
	</li>	
	<li><a href="aboutus.jsp">About</a></li>
	<li><a href="contact.jsp">Contact</a></li>
</ul>
</nav>
</aside>
<div class="body">
<section id="content">
<% 
	String getValue=request.getParameter("simulate"); 
	%>
<form method="post" action="ILight.jsp" name="light" onunload="ILight.jsp" onSubmit="return validate();">

 <table style="background-color:lightblue;" width=auto align="right">
 <tr><td><font color= red> For Demo/Test Purpose Only</font></td></tr>
 <tr>
 
 <td><font color=red>Light Sensor Simulator: </font></td><td> <input type="range"  min="0" max="100" step="5" name="demo1" onchange="lightSensor(this.value)"></td>
 <br>
 </tr>
 <tr>
 <td>
 <a href="addlight.jsp"><input type="button" name="addLight" value="Add Light Devices"></a>

 </td>
 </tr>
 </table>
 <table>
 <tr>
 <td>Select Room: </td><td> <select name="roomdata" onchange="rooms(this.value)">
			<option id="AllRooms">All Rooms</option>
			<%
try{
 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
 
 String sqlOption="select distinct rooms from roomie";
 PreparedStatement psLight=null;
 psLight=con.prepareStatement(sqlOption);
 
 ResultSet rsLight = null;
 
 rsLight=psLight.executeQuery();
 
 while(rsLight.next()){
     %>
			<option id="<%=rsLight.getString(1) %>"
				value="<%= rsLight.getString(1) %>"><%=rsLight.getString(1)%></option>
			<%
 }
     %>
		</select>
     </td>
     </tr>

<br>
<tr>
<br><td>Pre-set Conditions</td><td> <select name="Cond" onChange="optionChange(this.value)">
<option value=99>Select..</option>
<option value=0>OFF</option>
<option value=3>Dim</option>
<option value=1>Natural</option>
<option value=2>Read</option>

</select></td>
</tr>
<br>
<br>
</table>
<div class="status">
<section>


<table name="room" id="room">
<th>Device Name</th>
	 <th> Status </th>
<%

 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
 
 String sqlOption1="select * from roomie group by lights";
 PreparedStatement psLight1=null;
 
 
 psLight1=con.prepareStatement(sqlOption1);
 
 
 ResultSet rsLight1=null;
 
 rsLight1=psLight1.executeQuery();
 int s;


 
 while(rsLight1.next()){
	
	 %>
	 
     <tr>
		<td class="<%=rsLight1.getString(1)%>" style="border:1px solid black;"><%=rsLight1.getString(2)%></td>
		<% s=Integer.parseInt(rsLight1.getString(3));
     switch(s)
     {
     case 1:
     %>
    	 <td class="<%=rsLight1.getString(1)%>" style="border:1px solid black;"><input type="range" min="0" max="100" value="<%= rsLight1.getString(5) %>" name="<%= rsLight1.getString(2) %>"></td>
    	
     <% break;
     case 0:
     %>
     <td class="<%=rsLight1.getString(1)%>" style="border:1px solid black;"><input type="radio" name="<%= rsLight1.getString(2) %>" value=1 <%if(Integer.parseInt(rsLight1.getString(5))==1){ %>checked<%}%>>ON
     <input type="radio" name="<%= rsLight1.getString(2) %>" value=0 <%if(Integer.parseInt(rsLight1.getString(5
    		 ))==0){ %>checked<%}%>>OFF</td>
     <% break;
     }
     %></tr> 
 <%
 }
 
 if(psLight1!=null){
     psLight1.close();
 }
 if(rsLight1!=null){
     rsLight1.close();
 }
 
 if(con1!=null){
  con1.close();
  
 }

}
catch(Exception e)
{
	  e.printStackTrace();
}

 %>

 
</table>
<br>

<br>
<!--  <input type="button" value="simulate" onclick="lightSensor(<% out.println(getValue);%>)">-->
<!--  <button onclick="lightSensor(<%out.println(getValue); %>)">Simulate</button>-->
<input type="submit" value="Apply" id="button">

<!-- 
<p align="right">
 <a href="http://localhost:8080/start/addlight.jsp"><input type="button" name="addLight" value="Add Light Devices"></a>
 </p> -->
</form>
<table width="100%" border= "0">
<tr><td><span type="text" id="lblMessage" name="lblMessage" class="color-red">&copy Design and Code by Team Omega</span></td> </tr>
</table>
</div>
</body>
</html>
