<%@ page language="java" import="java.sql.*" errorPage="" %>
<%@ page import="javax.sql.DataSource,com.mysql.jdbc.Driver;" %>
<%

    Connection conn = null;
	PreparedStatement pscheckusername;
	ResultSet rs;
	Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_shas","root", "password");
    String flag;
    
    String uName=request.getParameter("username");
    String uPass=request.getParameter("password");
    String fName = request.getParameter("firstname");
    String lName = request.getParameter("lastname");
   
    try{
    	
    	String sqlusername="select * FROM Users where username='"+uName+"'";
         pscheckusername=conn.prepareStatement(sqlusername);
        
        rs=pscheckusername.executeQuery();
        
        if(rs.next())
        {
        	flag="0";
        	session.setAttribute("error", flag);
        	response.sendRedirect("Registration.jsp?statusmsg="+"registration error");
        }
        
        else
        {
    	
    PreparedStatement ps = conn.prepareStatement("INSERT INTO Users(username,password,firstname,lastname) VALUES(?,?,?,?)");
	ps.setString(1, uName);
	ps.setString(2, uPass);
	ps.setString(3, fName);
	ps.setString(4, lName);
  	int i = ps.executeUpdate();
  	
  	if(i>0)
  	{
  		flag="1";
  		session.setAttribute("success",flag);
  		response.sendRedirect("LoginPage.jsp?statusmsg="+"registration successful");	
  	}
  	
  	
	} 
   }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    /// close object and connection
    try{
         
         if(conn!=null){
          conn.close();
         }
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }


%>