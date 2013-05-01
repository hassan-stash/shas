<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Light Sensor Simulator</title>
<link rel="stylesheet" type="text/css" href="LightPage.css">
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
<div id="Logoname">Light Sensor Simulator</div>
</section>
<div class="container">
<section id="content">
<form method="post" name="frmRegistration" onSubmit="return validate();" action="light.jsp">
Light Sensor Simulator: <input type="range" value="100" name="simulate" min="0" max="100" step="5"  onchange="lightSensor(this.value)">
<br>
<button>Submit</button>
</section>
</div>
</form>

</body>
</html>