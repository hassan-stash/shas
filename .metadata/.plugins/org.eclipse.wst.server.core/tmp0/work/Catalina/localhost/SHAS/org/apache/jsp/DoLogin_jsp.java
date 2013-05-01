package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.DataSource;
import com.mysql.jdbc.Driver;;

public final class DoLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');


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
     
      response.sendRedirect("success.jsp?statusmsg="+message);
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


    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
