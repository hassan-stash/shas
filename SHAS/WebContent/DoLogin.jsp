<%@ page language="java" import="java.sql.*" errorPage="" %>
<%@ page import="javax.sql.DataSource,com.mysql.jdbc.Driver;" %>
<%

    Connection conn = null;
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
    
    ResultSet rsdoLogin = null;
    PreparedStatement psdoLogin=null;
    
    String sUserID=request.getParameter("username");
    String sPassword=request.getParameter("password");
    String message="User login successfully ";
    
    try{
    String sqlOption="select * FROM Users where username='"+sUserID+"' and Password='"+sPassword+"'";
    psdoLogin=conn.prepareStatement(sqlOption);
//     psdoLogin.setString(1,sUserID);
//     psdoLogin.setString(2,sPassword);
    
    rsdoLogin=psdoLogin.executeQuery();
    
    if(rsdoLogin.next())
    {
      String sUserName=rsdoLogin.getString("firstname")+" "+rsdoLogin.getString("lastname");
      session.setAttribute("sUserID",sUserName);
      //session.setAttribute("sUserID",rsdoLogin.getString("firstname"));
//       session.setAttribute("iUserType",rsdoLogin.getString("iUserType"));
//       session.setAttribute("iUserLevel",rsdoLogin.getString("iUserLevel"));
//       session.setAttribute("sUserName",sUserName);
     
      response.sendRedirect("home.jsp?statusmsg="+message);
    }
    else
    {
      message="Invalid credentials" ;
      response.sendRedirect("Invalid.jsp?error="+message);
    }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    
    /// close object and connection
    try{
         if(psdoLogin!=null){
             psdoLogin.close();
         }
         if(rsdoLogin!=null){
             rsdoLogin.close();
         }
         
         if(conn!=null){
          conn.close();
         }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

%>