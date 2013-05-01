<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% 

if(session.getAttribute("sUserID") == null)

response.sendRedirect("Invalid.jsp?error="+"invalid access");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sprinkler GUI</title>

<link rel="stylesheet" href="css/general.css" />
<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.1.custom.css" />
<link rel="stylesheet" type="text/css"
	href="css/ui-lightness/jquery-ui-1.10.1.custom.min.css" />
<link rel="stylesheet" type="text/css" href="css/timepicker.css" />

<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.1.custom.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.10.1.custom.min.js"></script>
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
</script>

<script>
	$(document).ready(function() {
		$(function() {
			$('#selectedDateTime').datetimepicker();
		});
		$(function() {
			$('#fromDate').datetimepicker({
				dateFormat : 'yy-mm-dd'

			});
		});
		$(function() {
			$('#toDate').datetimepicker({
				dateFormat : 'yy-mm-dd'

			});
		});

		$(function() {
			$('#MonFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',
				timeOnly:true

			});
		});

		$(function() {
			$('#MonTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',
				timeOnly:true

			});
		});

		$(function() {
			$('#TueFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		$(function() {
			$('#TueTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		
		$(function() {
			$('#WedFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		$(function() {
			$('#WedTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});

		$(function() {
			$('#ThuFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		$(function() {
			$('#ThuTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});

		$(function() {
			$('#FriFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		$(function() {
			$('#FriTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		
		$(function() {
			$('#SatFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		$(function() {
			$('#SatTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		
		$(function() {
			$('#SunFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		$(function() {
			$('#SunTotime').datetimepicker({
				dateFormat : 'yy-mm-dd',timeOnly:true

			});
		});
		
		$(function() {
			$('#DownFromtime').datetimepicker({
				dateFormat : 'yy-mm-dd'

			});
		});
		$(function() {
			$('#DownTotime').datetimepicker({
				dateFormat : 'yy-mm-dd'

			});
		});		
	

	});

	function clickschedule() {
		document.sprinklerform.btnSchedule.value = "Sprinkler Off";
		//sprinklerform.submit();
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
	
%>
</div>
<!-- end of welcomeName --></div>

<aside>
<nav>
<ul id="menu">
	<li><a href="home.jsp">Home</a></li>
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

<div id="content">
<form name="sprinklerform" action="SprinklerServlet" method="post"><br>
<%
ServletContext context = request.getSession().getServletContext();
	String btnScheduleValue;
	boolean ten = false;
	boolean twenty = false;
	boolean thirty = false;
	boolean forty = false;
	boolean fifty = false;
	boolean sixty = false;
	boolean seventy = false;
	boolean eighty = false;
	boolean ninety = false;
	boolean hundred = false;
	
	boolean monday = false;
	boolean tuesday = false;
	boolean wednesday =false;
	boolean thursday = false;
	boolean friday =false;
	boolean saturday =false;
	boolean sunday =false;
	boolean downtime =false;
	
	String strMessage ="";
	String strSuccessMessage =""; 
	System.out.println("inside the ------------------ error");
	
	if((String)request.getAttribute("ssReqFieldDefault")!= null)
	{		
		System.out.println((String)request.getAttribute("ssReqFieldDefault"));
		strMessage = (String)request.getAttribute("ssReqFieldDefault");
	}

	if((String)request.getAttribute("ssSprinklerOn")!= null)
	{
		strSuccessMessage = (String)request.getAttribute("ssSprinklerOn");
	}
	
	//-------------days set ------------------------------------------------------------------------------------//
	
	
	
	if((String)context.getAttribute("cmonday")!=null)
	{
		monday = true;
	}
	else
	{
		System.out.println((String)context.getAttribute("cmonday"));
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	if((String)context.getAttribute("ctuesday")!=null)
	{
	 tuesday = true;
	}
	if((String)context.getAttribute("cwednesday")!=null)
	{
	 wednesday = true;
	}
	if((String)context.getAttribute("cthursday")!=null)
	{
	 thursday = true;
	}
	if((String)context.getAttribute("cfriday")!=null)
	{
	 friday = true;
	}
	if((String)context.getAttribute("csaturday")!=null)
	{
	 saturday = true;
	}
	if((String)context.getAttribute("csunday")!=null)
	{
	 sunday = true;
	}
	if((String)context.getAttribute("cdown")!=null)
	{
	 downtime = true;
	}
	
	
	String MonFromtime = (String) context
	.getAttribute("cMonFrom");
	String MonTotime = (String) context
	.getAttribute("cMonTo");
	if (MonFromtime == null)
	{
		MonFromtime = "";
	}
	if(MonTotime == null)
	{
		MonTotime ="";
	}
	
	String TueFromtime= (String) context
	.getAttribute("cTueFrom");
	String TueTotime= (String) context
	.getAttribute("cTueTo");
	if (TueFromtime == null)
	{
		TueFromtime = "";
	}
	if(TueTotime == null)
	{
		TueTotime ="";
	}
	
	String WedFromtime= (String) context	
	.getAttribute("cWedFrom");
	String WedTotime= (String) context
	.getAttribute("cWedTo");
	if (WedFromtime == null)
	{
		WedFromtime = "";
	}
	if(WedTotime == null)
	{
		WedTotime ="";
	}
	
	String ThuFromtime= (String) context	
	.getAttribute("cThuFrom");
	String ThuTotime= (String) context
	.getAttribute("cThuTo");
	if (ThuFromtime == null)
	{
		ThuFromtime = "";
	}
	if(ThuTotime == null)
	{
		ThuTotime ="";
	}
	
	String FriFromtime= (String) context	
	.getAttribute("cFriFrom");
	String FriTotime= (String) context
	.getAttribute("cFriTo");
	if (FriFromtime == null)
	{
		FriFromtime = "";
	}
	if(FriTotime == null)
	{
		FriTotime ="";
	}
	
	String SatFromtime= (String) context
	.getAttribute("cSatFrom");
	String SatTotime= (String) context
	.getAttribute("cSatTo");
	if (SatFromtime == null)
	{
		SatFromtime = "";
	}
	if(SatTotime == null)
	{
		SatTotime ="";
	}
	
	
	String SunFromtime= (String) context
	.getAttribute("cSunFrom");
	String SunTotime= (String) context
	.getAttribute("cSunTo");
	if (SunFromtime == null)
	{
		SunFromtime = "";
	}
	if(SunTotime == null)
	{
		SunTotime ="";
	}
	
	
	String DownFromtime= (String) context
	.getAttribute("cDwnFrom");
	String DownTotime= (String) context
	.getAttribute("cDwnTo");
	if (DownFromtime == null)
	{
		DownFromtime = "";
	}
	if(DownTotime == null)
	{
		DownTotime ="";
	}
		
	//-----------------------------------------//
	
	
	
	System.out.println("in scriplet");
	if (request.getAttribute("schedulerstatus") == null) {
		btnScheduleValue = "Scheduler On";
	} else {

		btnScheduleValue = (String) request
				.getAttribute("schedulerstatus");
	
	}

	String selectedFromdate = (String) context.getAttribute("cfromDate");
	String selectedTodate = (String) context.getAttribute("ctoDate");
	if (selectedFromdate == null) {
		selectedFromdate = "";
	}
	if (selectedTodate == null) {
		selectedTodate = "";
	}

	//------------ for setting field values ----------------------------//
	System.out.println("beforen switch");
	System.out.println("outn switch");
%>

<article>
<table>
<tr><td><span id ="message" style="color:red" ><%= strMessage %></span> </td></tr>
<tr><td><span id ="successmessage" style="color:green" ><%= strSuccessMessage %></span> </td></tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<td colspan="6">
		<h3>Sprinkler</h3>
		</td>
	<tr>
		<td>
		<table border="0">
		
			<tr>
				<td>From
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input type="text" id="fromDate" name="fromDate"
					value="<%=selectedFromdate%>" class="dateinput" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td></td>

			</tr>
		</table>

<table border="0">
	<tr>
		<td></td>
		<td> 
		</td>
		<td>Start Time 
		</td>
		<td>End Time </td>
	</tr>
	<tr>
		<td >Monday</td>
		<td ><input type="checkbox" name="chkMon" id="chkMon" <%if (monday == true) {%> checked="checked" <%}%> ></td>
		<td valign="top"><input type="text" id="MonFromtime" name="MonFromtime" class="timeinput"
			value="<%=MonFromtime%>" /></td>

		<td valign="top"><input type="text" id="MonTotime" name="MonTotime" class="timeinput"
			value="<%=MonTotime%>" /></td>
	</tr>
	<tr>
		<td>Tuesday</td>
		<td><input type="checkbox" name="chkTue" name="chkTue" <%if (tuesday == true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="TueFromtime" name="TueFromtime" class="timeinput"
			value="<%=TueFromtime%>" /></td>

		<td><input type="text" id="TueTotime" name="TueTotime" class="timeinput"
			value="<%=TueTotime%>" /></td>
	</tr>
	<tr>
		<td>Wednesday</td>
		<td><input type="checkbox" name="chkWed" name="chkWed" <%if (wednesday == true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="WedFromtime" name="WedFromtime" class="timeinput"
			value="<%=WedFromtime%>" /></td>

		<td><input type="text" id="WedTotime" name="WedTotime" class="timeinput"
			value="<%=WedTotime%>" /></td>
	</tr>
	
	</tr>
		<tr>
		<td>Thursday</td>
		<td><input type="checkbox" name="chkThu" name="chkThu" <%if (thursday == true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="ThuFromtime" name="ThuFromtime" class="timeinput"
			value="<%=ThuFromtime%>" /></td>

		<td><input type="text" id="ThuTotime" name="ThuTotime" class="timeinput"
			value="<%=ThuTotime%>" /></td>
	</tr>
	<tr>
		<td>Friday</td>
		<td><input type="checkbox" name="chkFri" name="chkFri" <%if (friday == true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="FriFromtime" name="FriFromtime" class="timeinput"
			value="<%=FriFromtime%>" /></td>

		<td><input type="text" id="FriTotime" name="FriTotime" class="timeinput"
			value="<%=FriTotime%>" /></td>
	</tr>
	<tr>
		<td>Saturday</td>
		<td><input type="checkbox" name="chkSat" name="chkSat" <%if (saturday== true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="SatFromtime" name="SatFromtime" class="timeinput"
			value="<%=SatFromtime%>" /></td>

		<td><input type="text" id="SatTotime" name="SatTotime" class="timeinput"
			value="<%=SatTotime%>" /></td>
	</tr>
	<tr>
		<td>Sunday</td>
		<td><input type="checkbox" name="chkSun" name="chkSunday"
			<%if (sunday == true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="SunFromtime" name="SunFromtime" class="timeinput"
			value="<%=SunFromtime%>" /></td>
		<td><input type="text" id="SunTotime" name="SunTotime" class="timeinput"
			value="<%=SunTotime%>" /></td>
	</tr>
	<tr>

		<td>Down time</td>
		<td><input type="checkbox" name="chkDown" name="chkDown"
			<%if (downtime == true) {%> checked="checked" <%}%>></td>
		<td><input type="text" id="DownFromtime" name="DownFromtime" class="dateinput"
			value="<%=DownFromtime%>" /></td>

		<td><input type="text" id="DownTotime" name="DownTotime" class="dateinput"
			value="<%=DownTotime%>" /></td>

	</tr>
</table>
<table border="0">
	<tr>
		<td>To &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td><input type="text" id="toDate" name="toDate"
			value="<%=selectedTodate%>" class="dateinput" /></td>
			<td><input type="submit" id="btnSchedule" name="btnSchedule"
			value="<%=btnScheduleValue%>" class="buttonorange" /></td>	
			</td>
			<td><input type="submit" id="btnScheduleOff" name="btnScheduleOff"
			value="Scheduler Off" class="buttonorange " /></td>		
	</tr>	
</table>
</article>
</form>
</div>
</body>
</html>