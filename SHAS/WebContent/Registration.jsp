<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="Register.css">
</head>
<body>
<div class="container">
<section id="content">
<form method="post" action="doRegistration.jsp">
<h1>Registration</h1>
<div>
<input type="text" required="required" name="username" placeholder="Username">
</div>

<div>
<input type="password" required="required" placeholder="Password" name="password">
</div>
<div>
<input type="text" required="required" placeholder="Firstname" name="firstname">
</div>
<div>
<input type="text" required="required" placeholder="Lastname" name="lastname">
</div>
<div>
<button id="loginbtn">Register</button>
<a href="LoginPage.jsp">Login</a>
</div>
</form> <!-- form -->
</section> <!-- content -->
</div>
<%if(session.getAttribute("error")=="0") 
{%><div style="display: block; position: relative; font-size: 20px;
font-family: Arial, Helvetica, sans-serif; top: 46px;
text-align: center;
color: red;"><%out.write("Username already exists");}%>
</div>
</body>
</html>
