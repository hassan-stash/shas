<%@ page language="java" import="java.sql.*,java.util.*,javax.servlet.*,java.text.*" errorPage="" %>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Interface Light</title>
</head>
<script>

	
</script>
<% 
Class.forName("com.mysql.jdbc.Driver").newInstance();  
Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");

String sqlOption1="select * from roomie";
PreparedStatement psLight1=null;
ResultSet rsLight1=null;
Statement sUpdate=null;
Statement stLightupdate=null;
stLightupdate=con2.createStatement();

psLight1=con.prepareStatement(sqlOption1);

rsLight1=psLight1.executeQuery();
String sLightStatus="";
String sValues="";
String sroomSelection="";
String sqlUpdate=null;
String sqlUpdate1=null;

while(rsLight1.next())
{
 sLightStatus=rsLight1.getString(2);
 //out.println(sLightStatus);
 sroomSelection=request.getParameter("roomdata");
 sValues=request.getParameter(sLightStatus);
 //out.println(sValues);
 if (Integer.parseInt(sValues)==0)
 {
	 sqlUpdate="update roomie set datetimeoff=current_timestamp";
	 if(sroomSelection=="All Rooms")
	 {
		 sqlUpdate1= sqlUpdate.concat( ", value='"+sValues+"' where lights='"+sLightStatus+"' and rooms='"+sroomSelection+"';");
		 
	 }
	 else
	 {
		 sqlUpdate1=sqlUpdate.concat(", value='"+sValues+"' where lights='"+sLightStatus+"';");
		 
	 }
	// out.println(sqlUpdate1);
	 //stLightupdate.execute(sqlUpdate1);
	 //sqlUpdate1=null;
 }
 else
 {
	 sqlUpdate="update roomie set datetimeon=current_timestamp";
	 if(sroomSelection=="All Rooms")
	 {
		 sqlUpdate1=sqlUpdate.concat( ", value="+sValues+" where lights='"+sLightStatus+"' and rooms='"+sroomSelection+"';");
		 
		 
	 }
	 else
	 {
		 sqlUpdate1=sqlUpdate.concat(", value='"+sValues+"' where lights='"+sLightStatus+"';");
		 
	 }
	 //out.println(sqlUpdate1+"\n");
	// stLightupdate.execute(sqlUpdate1);
	 
 }
  stLightupdate.execute(sqlUpdate1);
  sqlUpdate1=null;
  
}

psLight1.close();
stLightupdate.close();
con1.close();
con2.close();
con.close();
  response.sendRedirect("light.jsp");
    
%>

</body>
</html>
