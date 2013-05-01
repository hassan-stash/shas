package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String strSprinklerLevel;
String strSprinklerPower;


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
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Successfully Login by JSP</title>\n");
      out.write("<link href='http://fonts.googleapis.com/css?family=Wendy+One'\n");
      out.write("\trel='stylesheet' type='text/css'>\n");
      out.write("<script src=\"http://code.jquery.com/jquery-latest.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/timepicker.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction initMenu() {\n");
      out.write("\t\t$('#menu ul').hide(); // Hide the submenu\n");
      out.write("\t\tif ($('#menu li').has('ul'))\n");
      out.write("\t\t\t$('#menu ul').prev().addClass('expandable'); // Expand/collapse a submenu when it exists  \n");
      out.write("\t\t$('.expandable').click(function() {\n");
      out.write("\t\t\t$(this).next().slideToggle();\n");
      out.write("\t\t\t$(this).toggleClass('expanded');\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t// When document ready, call initMenu() function \n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\tinitMenu();\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write("input {\n");
      out.write("\tborder: 1px solid #FAB066;\n");
      out.write("\t-webkit-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px\n");
      out.write("\t\trgba(0, 0, 0, 0.1);\n");
      out.write("\t-moz-box-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px\n");
      out.write("\t\trgba(0, 0, 0, 0.1);\n");
      out.write("\tbox-shadow: inset 0 0 8px rgba(0, 0, 0, 0.1), 0 0 16px\n");
      out.write("\t\trgba(0, 0, 0, 0.1);\n");
      out.write("\tpadding: 15px;\n");
      out.write("\tbackground: rgba(255, 255, 255, 0.5);\n");
      out.write("\tmargin: 0 0 10px 0;\n");
      out.write("}\n");
      out.write("body {\n");
      out.write("\tbackground: #eee\n");
      out.write("\t\turl(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAUAAAAFCAMAAAC6sdbXAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAAZQTFRF3d3d////riJKgAAAAAJ0Uk5T/wDltzBKAAAAFUlEQVR42mJgBAEGGMmAxAYCgAADAAGGABmnk/7aAAAAAElFTkSuQmCC);\n");
      out.write("\tfont-family: Arial, Helvetica, sans-serif;\n");
      out.write("\tfont-size: 16px;\n");
      out.write("\tmargin: 0;\n");
      out.write("\tpadding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#header {\n");
      out.write("\tbackground: none repeat scroll 0 0 #000000;\n");
      out.write("\theight: 50px;\n");
      out.write("\twidth: 100%;\n");
      out.write("\ttop: 15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#topmenu ul {\n");
      out.write("\tfloat: left;\n");
      out.write("\ttop: 15px;\n");
      out.write("\tpadding: 0;\n");
      out.write("\ttext-align: center;\n");
      out.write("\twidth: auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("ul {\n");
      out.write("\tlist-style: none outside none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#topmenu li {\n");
      out.write("\tlist-style-type: none;\n");
      out.write("\tpadding-left: 38px;\n");
      out.write("\tpadding-right: 38px;\n");
      out.write("\tdisplay: inline;\n");
      out.write("\theight: 22px;\n");
      out.write("\ttext-align: center;\n");
      out.write("\twidth: auto;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#logout {\n");
      out.write("\tfloat: right;\n");
      out.write("\tposition: relative;\n");
      out.write("\ttop: 15px;\n");
      out.write("\tpadding-right: 25px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a {\n");
      out.write("\tcolor: #E56A22;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#topmenu {\n");
      out.write("\tdisplay: block;\n");
      out.write("\tfloat: left;\n");
      out.write("\tposition: relative;\n");
      out.write("\tcolor: white;\n");
      out.write("\theight: 30px;\n");
      out.write("\twidth: 800px;\n");
      out.write("\tleft: 50px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#welcomeName {\n");
      out.write("\tcolor: white;\n");
      out.write("\tfloat: right;\n");
      out.write("\tposition: relative;\n");
      out.write("\ttop: 15px;\n");
      out.write("\tright: 30px;\n");
      out.write("\tpadding-right: 2px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("aside {\n");
      out.write("\tfloat: left;\n");
      out.write("\tmargin-right: 20px;\n");
      out.write("\twidth: 250px;\n");
      out.write("\tdisplay: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write("nav {\n");
      out.write("\tdisplay: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Vertical menu */\n");
      out.write("#menu {\n");
      out.write("\tdisplay: block;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu ul {\n");
      out.write("\tposition: relative;\n");
      out.write("\tpadding: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu li {\n");
      out.write("\tmargin: 0 0 3px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu a {\n");
      out.write("\tdisplay: block;\n");
      out.write("\t*display: inline-block;\n");
      out.write("\t*width: 240px;\n");
      out.write("\ttext-decoration: none;\n");
      out.write("\tbackground: #ddd;\n");
      out.write("\tcolor: #444;\n");
      out.write("\tpadding: 10px 5px;\n");
      out.write("\ttext-transform: uppercase;\n");
      out.write("\tfont: bold 14px Arial, Helvetica, sans-serif;\n");
      out.write("\t-moz-border-radius: 5px;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("\t-moz-box-shadow: 0 1px 0 #ccc;\n");
      out.write("\t-webkit-box-shadow: 0 1px 0 #ccc;\n");
      out.write("\tbox-shadow: 0 1px 0 #ccc;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu a:hover {\n");
      out.write("\tcolor: #eee;\n");
      out.write("\tbackground: #9c9c9c;\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, from(#bbb),\n");
      out.write("\t\tto(#999) );\n");
      out.write("\tbackground: -webkit-linear-gradient(top, #bbb, #999);\n");
      out.write("\tbackground: -moz-linear-gradient(top, #bbb, #999);\n");
      out.write("\tbackground: -ms-linear-gradient(top, #bbb, #999);\n");
      out.write("\tbackground: -o-linear-gradient(top, #bbb, #999);\n");
      out.write("\tbackground: linear-gradient(top, #bbb, #999);\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu .expandable {\n");
      out.write("\tposition: relative;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu .expandable:before,#menu .expandable:after {\n");
      out.write("\tcontent: '';\n");
      out.write("\tposition: absolute;\n");
      out.write("\tright: 5px;\n");
      out.write("\tmargin-top: 5px;\n");
      out.write("\tborder-top: 6px solid #444;\n");
      out.write("\tborder-right: 6px solid transparent;\n");
      out.write("\tborder-left: 6px solid transparent;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu .expandable:before {\n");
      out.write("\tborder-top-color: #fff;\n");
      out.write("\tmargin-top: 6px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu .expanded:after {\n");
      out.write("\tborder-top: 0;\n");
      out.write("\tborder-bottom: 6px solid #444;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu .expanded:before {\n");
      out.write("\tborder-top: 0;\n");
      out.write("\tborder-bottom: 6px solid #fff;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu ul a {\n");
      out.write("\tbackground: #f2f2f2;\n");
      out.write("\ttext-transform: none;\n");
      out.write("\tfont-weight: normal;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#menu ul a:hover {\n");
      out.write("\tbackground: #fafafa;\n");
      out.write("\tcolor: #444;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#logo {\n");
      out.write("\tcolor: #ffffff;\n");
      out.write("\tfont-family: 'Wendy One', sans-serif;\n");
      out.write("\tfont-size: 45px;\n");
      out.write("\tposition: relative;\n");
      out.write("\tleft: 30px;\n");
      out.write("\tfloat: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("footer {\n");
      out.write("\tposition: relative;\n");
      out.write("\ttext-align: right;\n");
      out.write("\twidth: 800px;\n");
      out.write("\tbackground-color: white;\n");
      out.write("\tdisplay: block;\n");
      out.write("\ttop: 559px;\n");
      out.write("\theight: 20px;\n");
      out.write("\tfont-size: 14px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("section {\n");
      out.write("\tposition: relative;\n");
      out.write("\tdisplay: block;\n");
      out.write("\ttop: 15px;\n");
      out.write("\tleft: 18px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#content {\n");
      out.write("\tfloat: left;\n");
      out.write("\twidth: 800px;\n");
      out.write("}\n");
      out.write("#main { \n");
      out.write("    width: 900px;\n");
      out.write("    margin: 0 auto;\n");
      out.write("}\n");
      out.write("#statusdiv    {\n");
      out.write("    width: 350px;\n");
      out.write("    height: 400px;    \n");
      out.write("    float: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#leveldiv  {\n");
      out.write("    width: 350px;    \n");
      out.write("    height: 400px;\n");
      out.write("    float: right;\n");
      out.write("    \n");
      out.write("}\n");
      out.write("\n");
      out.write("article {\n");
      out.write("\tposition: relative;\n");
      out.write("\tpadding: 20px;\n");
      out.write("\ttop: 15px;\n");
      out.write("\tmargin: 0 0 20px 0;\n");
      out.write("\ttext-align: left;\n");
      out.write("\tbackground: #fff;\n");
      out.write("\t-moz-box-shadow: 0 1px 1px #999;\n");
      out.write("\t-webkit-box-shadow: 0 1px 1px #999;\n");
      out.write("\tbox-shadow: 0 1px 1px #999;\n");
      out.write("\t-moz-border-radius: 5px;\n");
      out.write("\t-webkit-border-radius: 5px;\n");
      out.write("\tborder-radius: 5px;\n");
      out.write("\theight: 192px;\n");
      out.write("\twidth: 400px\n");
      out.write("}\n");
      out.write("\n");
      out.write("button {\n");
      out.write("\theight: 40px;\n");
      out.write("\twidth: 70px;\n");
      out.write("\tbackground-color: #DDDDDD;\n");
      out.write("\tborder: 1px solid #BBBBBB;\n");
      out.write("\tborder-radius: 3px 3px 3px 3px;\n");
      out.write("\tbox-shadow: 0 1px 0 rgba(0, 0, 0, 0.3), 0 2px 2px -1px\n");
      out.write("\t\trgba(0, 0, 0, 0.5), 0 1px 0 rgba(255, 255, 255, 0.3) inset;\n");
      out.write("\tcolor: #555555;\n");
      out.write("\tcursor: pointer;\n");
      out.write("\tfont: bold 13px arial, helvetica, sans-serif;\n");
      out.write("\ttext-shadow: 0 1px 0 rgba(255, 255, 255, 0.9);\n");
      out.write("\tposition: relative;\n");
      out.write("\tmargin-left: 30px;\n");
      out.write("\tpadding: 2px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("button:hover {\n");
      out.write("\tbackground-color: #EEEEEE;\n");
      out.write("\tcolor: #555555;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#sprinkbtn {\n");
      out.write("\tleft: 65px;\n");
      out.write("\tbackground-color: lightgreen;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#thermobtn {\n");
      out.write("\tleft: 49px;\n");
      out.write("\tbackground-color: ff3300;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#lightbtn {\n");
      out.write("\tleft: 72px;\n");
      out.write("\tbackground-color: ff3300;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".status {\n");
      out.write("\tposition: relative;\n");
      out.write("\tmargin-left: 15px;\n");
      out.write("\ttext-align: left;\n");
      out.write("\tpadding: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#devstatustab {\n");
      out.write("\tposition: relative;\n");
      out.write("\tbackground: #4c4c4c; /* Old browsers */\n");
      out.write("\tbackground: -moz-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%, #1c1c1c\n");
      out.write("\t\t91%, #131313 100%); /* FF3.6+ */\n");
      out.write("\tbackground: -webkit-gradient(linear, left top, left bottom, color-stop(12%, #4c4c4c),\n");
      out.write("\t\tcolor-stop(51%, #111111), color-stop(76%, #2b2b2b),\n");
      out.write("\t\tcolor-stop(91%, #1c1c1c), color-stop(100%, #131313) );\n");
      out.write("\t/* Chrome,Safari4+ */\n");
      out.write("\tbackground: -webkit-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%,\n");
      out.write("\t\t#1c1c1c 91%, #131313 100%); /* Chrome10+,Safari5.1+ */\n");
      out.write("\tbackground: -o-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%, #1c1c1c\n");
      out.write("\t\t91%, #131313 100%); /* Opera 11.10+ */\n");
      out.write("\tbackground: -ms-linear-gradient(top, #4c4c4c 12%, #111111 51%, #2b2b2b 76%, #1c1c1c\n");
      out.write("\t\t91%, #131313 100%); /* IE10+ */\n");
      out.write("\tbackground: linear-gradient(to bottom, #4c4c4c 12%, #111111 51%, #2b2b2b 76%,\n");
      out.write("\t\t#1c1c1c 91%, #131313 100%); /* W3C */\n");
      out.write("\tfilter: progid : DXImageTransform.Microsoft.gradient (   startColorstr =\n");
      out.write("\t\t'#4c4c4c', endColorstr = '#131313', GradientType = 0 ); /* IE6-9 */\n");
      out.write("\twidth: 100%;\n");
      out.write("\theight: 20px;\n");
      out.write("\tcolor: white;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div id=\"header\">\n");
      out.write("<div id=\"logo\">SHAS</div>\n");
      out.write("<div id=\"logout\"><a href=\"LogoutPage.jsp\">Logout</a></div>\n");
      out.write("<!-- end of logout div -->\n");
      out.write("<div id=\"welcomeName\">\n");

	

      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- end of welcomeName --></div>\n");
      out.write("<!-- end of header -->\n");
      out.write("<aside>\n");
      out.write("<nav>\n");
      out.write("<ul id=\"menu\">\n");
      out.write("\t<li><a href=\"#\">Home</a></li>\n");
      out.write("\t<li><a href=\"#\" class=\"expandable\">Devices</a>\n");
      out.write("\t<ul style=\"display: none;\">\n");
      out.write("\t\t<li><a href=\"SprinklerGUI.jsp\">Sprinkler</a></li>\n");
      out.write("\t\t<li><a href=\"#\">Thermostat</a></li>\n");
      out.write("\t\t<li><a href=\"light.jsp\">Lighting</a></li>\n");
      out.write("\t</ul>\n");
      out.write("\t</li>\n");
      out.write("\t<li><a href=\"#\">Usage Reports</a></li>\n");
      out.write("\t<li><a href=\"#\">Settings</a></li>\n");
      out.write("\t<li><a href=\"#\">About</a></li>\n");
      out.write("\t<li><a href=\"#\">Contact</a></li>\n");
      out.write("</ul>\n");
      out.write("</nav>\n");
      out.write("</aside>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"content\">\n");
      out.write("\n");
      out.write("<form name=\"homeform\" action=\"HomeServlet\" method=\"post\">\n");
      out.write(' ');
      out.write('\n');

ServletContext context = request.getSession().getServletContext();

if(context.getAttribute("ssTotalLevel") != null) {
	System.out.println("in the home scriplettttttttttttttttttttttttt");
	 
	strSprinklerLevel = Float.toString((Float)context.getAttribute("ssTotalLevel"));

} 

if(context.getAttribute("ssTotalPower") != null) {
	System.out.println("in the home scriplettttttttttttttttttttttttt");
	 
	strSprinklerPower = Float.toString((Float)context.getAttribute("ssTotalPower"));

} 
 

      out.write("\n");
      out.write("\n");
      out.write("<div id=\"statusdiv\"><article> <section>\n");
      out.write("<div class=\"status\">\n");
      out.write("\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("<td><span>Sprinkler power usage unit</span></td><td><input type=\"text\" id=\"toDate\" name=\"toDate\"\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(strSprinklerPower);
      out.write("\" /></td></tr>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("<td><span>Thermostat power usage unit</span></td><td><input type=\"text\" id=\"toDate\" name=\"toDate\"\n");
      out.write("\t\t\t\t\tvalue=\"\" /></td></tr>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("<td><span>Lighting power usage unit</span></td><td><input type=\"text\" id=\"toDate\" name=\"toDate\"\n");
      out.write("\t\t\t\t\tvalue=\"\" /></td></tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</section> </article>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div id=\"leveldiv\"><article> <section>\n");
      out.write("<div class=\"status\">\n");
      out.write("\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("<td><span>Sprinkler Level :</span></td><td><input type=\"text\" id=\"toDate\" name=\"toDate\"\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(strSprinklerLevel);
      out.write("\" /></td></tr>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("<td><span>Thermostat Level :</span></td><td><input type=\"text\" id=\"toDate\" name=\"toDate\"\n");
      out.write("\t\t\t\t\tvalue=\"\" /></td></tr>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("<td><span>Lighting Level :</span></td><td><input type=\"text\" id=\"toDate\" name=\"toDate\"\n");
      out.write("\t\t\t\t\tvalue=\"\" /></td></tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</section> </article>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("<table width=\"100%\" border= \"0\">\n");
      out.write("<tr><td><span type=\"text\" id=\"lblMessage\" name=\"lblMessage\" class=\"color-red\">Design and Code by Team Omega</span></td> </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
