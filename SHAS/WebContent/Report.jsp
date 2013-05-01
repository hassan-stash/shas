<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Enumeration"%>

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
<title>Power usage</title>

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
		

		$(function() {
					$('#PfromDate').datetimepicker({
						dateFormat : 'yy-mm-dd'

					});
				});
		

		$(function() {
					$('#PtoDate').datetimepicker({
						dateFormat : 'yy-mm-dd'

					});
				});
	});
	
	
</script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />



  

<%!Hashtable<String, Integer> rsPower;%>
<%
String strMessage ="";
if((String)request.getAttribute("ssReqField")!= null)
{		
	System.out.println((String)request.getAttribute("ssReqField"));
	strMessage = (String)request.getAttribute("ssReqField");
}

String selectedFromdate = "";
String selectedTodate ="";

if((String) request.getAttribute("cPfromDate") != null)
{
	selectedFromdate = 	(String) request.getAttribute("cPfromDate");
}

if((String) request.getAttribute("cPtoDate") != null)
{
	selectedTodate = 	(String) request.getAttribute("cPtoDate");
}


%>
<%
String PFromdate = (String) request
.getAttribute("cPfromDate");
String PTodate = (String) request.getAttribute("cPtoDate");

	ServletContext context = request.getSession().getServletContext();
	if (context.getAttribute("rsPower") != null) {

		rsPower = (Hashtable<String, Integer>) context.getAttribute("rsPower");

	} else {
		System.out.println("In the ele paert");
		//rsPower = null;
	}
%>

<script type="text/javascript">
      
     
google.load('visualization', '1', {packages: ['gauge']});
    	  google.load("visualization", "1", {packages:["corechart"]});
          google.setOnLoadCallback(drawChart);  
          
     
      function drawChart() {
    	  <%int year = 2004;
			int pValue = 100;
			int wValue = 450;
			int n = 1;%>
        
        <%if (rsPower != null) {

				Enumeration e = rsPower.keys();%>
        
        var data = google.visualization.arrayToDataTable([
			['<%out.write("Date");%>', 'Power'],
            <%while (e.hasMoreElements()) {
					String key = e.nextElement().toString();%>            
            ['<%=key.substring(2,10)%>',  <%=rsPower.get(key)%>,],
            <%}%>
         
          
      
          /* ['2005',  1170,      460],
          ['2006',  660,       1120],
          ['2007',  1030,      540],
          ['2008',  750,      340],
          ['2009',  830,      640] */
        ]);

        var options = {
          title: 'Power Usage Reports',
          vAxis: {title: 'Date',  titleTextStyle: {color: 'red'}},
           colors: ['#FFA989']
          
        };
        
        var formatter = new google.visualization.NumberFormat({suffix: ' Kwh'});
        formatter.format(data, 1); // Apply formatter to second column

        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        
        
        <%}%>
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

<div id="content">
<form name="reportform" action="UsageServlet" method="post">



<div id="statusdiv"><article> <section>
<div class="status">
<h3>Power usage</h3>
<table>
<tr><td><span id ="message" style="color:red" ><%= strMessage %></span> </td></tr>
</table>
<table>
<tr>
<td>
Start Date: <input type="text" id="PfromDate" name="PfromDate" value="<%= selectedFromdate %>" class="dateinput" />
</td>
<td>
End Date: <input type="text" id="PtoDate" name="PtoDate" value="<%= selectedTodate %>"  class="dateinput" />
</td>
<td>
<input type="submit" id="btnGetPUsage" name="btnGetPUsage"
			value="Get" class="buttonorangesmall" />
</td>
</tr>
<tr>

</tr>
</table>

<div>


</div>
<div id="chart_div" style="width: 500px; height: 200px;"></div>
</div>


</div>
</section> </article>

</div>





</form>
</div>


</body>
</html>