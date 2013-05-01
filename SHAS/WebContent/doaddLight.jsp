<%@ page language="java" import="java.sql.*" errorPage="" %>
<% 
    Connection conn = null;
    Class.forName("com.mysql.jdbc.Driver").newInstance();
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
    
    
    PreparedStatement psdoaddLight=null;
    
    String roomlist=request.getParameter("roomlist");
    
    
    String devicename=request.getParameter("txtDeviceName");   
    
    int type=Integer.parseInt(request.getParameter("select1"));
    
    int iroomcond=Integer.parseInt(request.getParameter("roomcondition"));
    
    try{
    String sqlOption="insert into roomie(rooms,lights,buttonmode,precondition,value) values('"+roomlist+"','"+devicename+"','"+type+"','"+iroomcond+"','1')";
   
    psdoaddLight=conn.prepareStatement(sqlOption);
    psdoaddLight.executeUpdate(sqlOption);
    response.sendRedirect("light.jsp?error=");
    if(psdoaddLight!=null){
    	psdoaddLight.close();
    }
   
    
    
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
 
   
%>