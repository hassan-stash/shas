<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="3" align="center"><%@ include file="/WEB-INF/header.jsp"%></td>
  </tr>
  <tr>
    <td width="16%" height="138">&nbsp;</td>
    <td width="65%" align="center">This is Home page and having
                    header and footer included by include of JSP </td>
    <td width="19%">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="3" align="center"><%@ include file="footer.jsp"%></td>
  </tr>
</table>


</body>
</html>