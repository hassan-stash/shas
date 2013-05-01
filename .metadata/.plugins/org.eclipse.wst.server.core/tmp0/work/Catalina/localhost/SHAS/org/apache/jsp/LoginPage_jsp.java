package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=US-ASCII");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<!--[if lt IE 7 ]> <html lang=\"en\" class=\"ie6 ielt8\"> <![endif]-->\n");
      out.write("<!--[if IE 7 ]>    <html lang=\"en\" class=\"ie7 ielt8\"> <![endif]-->\n");
      out.write("<!--[if IE 8 ]>    <html lang=\"en\" class=\"ie8\"> <![endif]-->\n");
      out.write("<!--[if (gte IE 9)|!(IE)]><!--> <html lang=\"en\"> <!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<title>SHAS Login</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"LoginPage.css\">\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Wendy+One' rel='stylesheet' type='text/css'>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("#Logoname\n");
      out.write("{\n");
      out.write("color: #323232;\n");
      out.write("font-family: 'Wendy One', sans-serif;\n");
      out.write("font-size: 64px;\n");
      out.write("position: relative;\n");
      out.write("top: 0px;\n");
      out.write("left: 90px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#Logo\n");
      out.write("{\n");
      out.write("position: fixed;\n");
      out.write("width: 100%;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<section id=\"Logo\">\n");
      out.write("<div id=\"Logoname\">SHAS</div>\n");
      out.write("</section>\n");
      out.write("<div class=\"container\">\n");
      out.write("<section id=\"content\">\n");
      out.write("<form method=\"post\" action=\"DoLogin.jsp\">\n");
      out.write("<h1>User Login</h1>\n");
      out.write("<div>\n");
      out.write("<input type=\"text\" required=\"required\" name=\"username\" placeholder=\"Username\">\n");
      out.write("</div>\n");
      out.write("<div>\n");
      out.write("<input type=\"password\" required=\"required\" placeholder=\"Password\" name=\"password\">\n");
      out.write("</div>\n");
      out.write("<div>\n");
      out.write("<button id=\"loginbtn\">Log in</button>\n");
      out.write("<a href=\"#\">Lost your password?</a>\n");
      out.write("<a href=\"Registration.jsp\">Register</a>\n");
      out.write("</div>\n");
      out.write("</form> <!-- form -->\n");
      out.write("</section> <!-- content -->\n");
      out.write("</div>\n");
if(session.getAttribute("success")=="1")
	{

      out.write("\n");
      out.write("<div style=\"display:block; position: relative; font-size: 20px;\n");
      out.write("font-family: Arial, Helvetica, sans-serif;\n");
      out.write("color: red; top: 94px;\n");
      out.write("text-align: center;\">");
out.write("Registration Successful!");
	}
session.removeAttribute("success");	
session.invalidate();
	
      out.write("</div>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
