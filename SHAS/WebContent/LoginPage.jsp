<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>SHAS Login</title>
<link rel="stylesheet" type="text/css" href="LoginPage.css">
<link href='http://fonts.googleapis.com/css?family=Wendy+One' rel='stylesheet' type='text/css'>
<style type="text/css">
#Logoname
{
color: #323232;
font-family: 'Wendy One', sans-serif;
font-size: 64px;
position: relative;
top: 0px;
left: 90px;
}

#Logo
{
position: fixed;
width: 100%;
}
</style>
</head>
<body>
<section id="Logo">
<div id="Logoname">SHAS</div>
</section>
<div class="container">
<section id="content">
<form method="post" action="DoLogin.jsp">
<h1>User Login</h1>
<div>
<input type="text" required="required" name="username" placeholder="Username">
</div>
<div>
<input type="password" required="required" placeholder="Password" name="password">
</div>z
<div>
<button id="loginbtn">Log in</button>

<a href="Registration.jsp">Register</a>
</div>
</form> <!-- form -->
</section> <!-- content -->
</div>
<%if(session.getAttribute("success")=="1")
	{
%>
<div style="display:block; position: relative; font-size: 20px;
font-family: Arial, Helvetica, sans-serif;
color: red; top: 94px;
text-align: center;"><%out.write("Registration Successful!");
	}
session.removeAttribute("success");	
session.invalidate();
	%></div>
	

</body>
</html>
