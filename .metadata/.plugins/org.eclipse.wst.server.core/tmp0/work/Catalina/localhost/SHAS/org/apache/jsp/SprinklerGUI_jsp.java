package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;

public final class SprinklerGUI_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("  \r\n");
      out.write("<title>Sprinkler GUI page</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"css/ui-lightness/jquery-ui-1.10.1.custom.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"css/ui-lightness/jquery-ui-1.10.1.custom.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/timepicker.css\" />\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-ui-1.10.1.custom.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery-ui-1.10.1.custom.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/timepicker.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#selectedDateTime').datetimepicker();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#fromDate').datetimepicker({\r\n");
      out.write("\t\t\t\tdateFormat : 'yy-mm-dd'\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#toDate').datetimepicker({\r\n");
      out.write("\t\t\t\tdateFormat : 'yy-mm-dd'\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#overridefromDate').datetimepicker({\r\n");
      out.write("\t\t\t\tdateFormat : 'yy-mm-dd'\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#overrideToDate').datetimepicker({\r\n");
      out.write("\t\t\t\tdateFormat : 'yy-mm-dd'\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#shutFromDate').datetimepicker({\r\n");
      out.write("\t\t\t\tdateFormat : 'yy-mm-dd'\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$('#shutToDate').datetimepicker({\r\n");
      out.write("\t\t\t\tdateFormat : 'yy-mm-dd'\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction clickschedule() {\r\n");
      out.write("\t\tdocument.sprinklerform.btnSchedule.value = \"Sprinkler Off\";\r\n");
      out.write("\t\t//sprinklerform.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<form name=\"sprinklerform\" action=\"SprinklerServlet\" method=\"post\"><br>\r\n");

System.out.println("in scripletttttttttttttttttt");
	String btnScheduleValue;
	boolean ten = false;
	boolean twenty = false;
	boolean thirty = false;
	boolean forty = false;
	boolean fifty = false;
	boolean sixty = false;
	boolean seventy = false;
	boolean eighty = false;
	boolean ninety = false;
	boolean hundred = false;

	boolean minfifteen = false;
	boolean minthirty = false;
	boolean minfortyfive = false;
	boolean minsixty = false;

	System.out.println("in scriplet");
	if (request.getAttribute("schedulerstatus") == null) {
		btnScheduleValue = "Scheduler On";

	} else {

		btnScheduleValue = (String) request
				.getAttribute("schedulerstatus");

	}

	String selectedFromdate = (String) request
			.getAttribute("cfromDate");
	String selectedTodate = (String) request.getAttribute("ctoDate");
	if (selectedFromdate == null) {
		selectedFromdate = "";
	}
	if (selectedTodate == null) {
		selectedTodate = "";
	}

	//------------ for setting field values ----------------------------//
	System.out.println("beforen switch");

	String electedlevel = (String) request.getAttribute("clevel");
	if (electedlevel == null)
		electedlevel = "10";
	switch (Integer.parseInt(electedlevel)) {
	case 10:
		ten = true;
		System.out.println("in ten");
		break;
	case 20:
		twenty = true;
		System.out.println("in twenty");
		break;
	case 30:
		thirty = true;
		break;
	case 40:
		forty = true;
		break;
	case 50:
		fifty = true;
		break;
	case 60:
		sixty = true;
		break;
	case 70:
		seventy = true;
		break;
	case 80:
		eighty = true;
		break;
	case 90:
		ninety = true;
		break;
	case 100:
		hundred = true;
		System.out.println("in hindred");
		break;
	default:
		ten = true;
		break;
	}

	//-------maintain duration list ---------------------------------//
	String selectedDuration = (String) request
			.getAttribute("cduration");
	if (selectedDuration == null)
		selectedDuration = "15";
	switch (Integer.parseInt(selectedDuration)) {
	case 15:
		minfifteen = true;
		break;
	case 30:
		minthirty = true;
		System.out.println("in twenty");
		break;
	case 45:
		minfortyfive = true;
		break;
	case 60:
		minsixty = true;
		break;
	default:
		minfifteen = true;
		break;
	}

	System.out.println("outn switch");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table border=\"5\" width=\"100%\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"6\" align=\"center\">");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Header title</title>\r\n");
      out.write("<style>\r\n");
      out.write(".st\r\n");
      out.write("{\r\n");
      out.write("  background-color:#CBE0E7;\r\n");
      out.write("  font-weight:bold;\r\n");
      out.write("  text-align:center\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td class=\"st\">Home</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td class=\"st\">Devices</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    <td class=\"st\">Reports</td>\r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("    \r\n");
      out.write("    <td>&nbsp;</td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table width=\"100%\" border=\"4\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t<td colspan=\"6\">\r\n");
      out.write("\t\t<h3>Sprinkler</h3>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<table border=\"2\">\r\n");
      out.write("\t\t\t<tr height=\"60px\">\r\n");
      out.write("\t\t\t\t<td colspan=\"6\">Default Setting:</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>From Date :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"fromDate\" name=\"fromDate\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(selectedFromdate);
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t<td>To Date :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"toDate\" name=\"toDate\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(selectedTodate);
      out.write("\" /></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Sprinkler Level</td>\r\n");
      out.write("\t\t\t\t<td><select name=\"level\">\r\n");
      out.write("\t\t\t\t\t<option value=\"10\" ");
if (ten == true) {
      out.write(" selected=\"selected\" ");
}
      out.write(">10%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"20\" ");
if (twenty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">20%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"30\" ");
if (thirty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">30%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"40\" ");
if (forty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">40%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"50\" ");
if (fifty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">50%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"60\" ");
if (sixty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">60%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"70\" ");
if (seventy == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">70%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"80\" ");
if (eighty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">80%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"90\" ");
if (ninety == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">90%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"100\" ");
if (hundred == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">100%</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t<td>Duration</td>\r\n");
      out.write("\t\t\t\t<td><select name=\"duration\">\r\n");
      out.write("\t\t\t\t\t<option value=\"15\" ");
if (minfifteen == true) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\tselected=\"selected\" ");
}
      out.write(">15 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"30\" ");
if (minthirty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">30 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"45\" ");
if (minfortyfive == true) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\tselected=\"selected\" ");
}
      out.write(">45 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"60\" ");
if (minsixty == true) {
      out.write(" selected=\"selected\"\r\n");
      out.write("\t\t\t\t\t\t");
}
      out.write(">60 Min</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" id=\"btnSchedule\" name=\"btnSchedule\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(btnScheduleValue);
      out.write("\" /></td>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<table border=\"2\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=6\">Schedule Override:</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>From Date :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"overridefromDate\"\r\n");
      out.write("\t\t\t\t\tname=\"overridefromDate\" /></td>\r\n");
      out.write("\t\t\t\t<td>To Date :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"overrideToDate\"\r\n");
      out.write("\t\t\t\t\tname=\"overrideToDate\" /></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>Sprinkler Level</td>\r\n");
      out.write("\t\t\t\t<td><select name=\"overrideLevel\">\r\n");
      out.write("\t\t\t\t\t<option value=\"10\">10%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"20\">20%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"30\">30%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"40\">40%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"50\">50%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"60\">60%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"70\">70%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"80\">80%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"90\">90%</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"100\">100%</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t<td>Duration</td>\r\n");
      out.write("\t\t\t\t<td><select name=\"overrideDuration\">\r\n");
      out.write("\t\t\t\t\t<option value=\"10\">15 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"30\">30 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"40\">45 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"60\">60 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"75\">1 hr 15 Min</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"90\">1 hr 30 Min</option>\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t<td>Recur:<input type=\"checkbox\" name=\"chkRecur\"\r\n");
      out.write("\t\t\t\t\tname=\"chkRecur\" checked=\"checked\"></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" name=\"btnApplyOverride\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Override On\" /></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t<table border=\"2\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"6\">Maintenance Shutdown Setting:</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>From Date :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"shutFromDate\" name=\"shutFromDate\" /></td>\r\n");
      out.write("\t\t\t\t<td>To Date :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"shutToDate\" name=\"shutToDate\" /></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" name=\"btnApplyMaintenance\"\r\n");
      out.write("\t\t\t\t\tvalue=\"Maintenance On\" /></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"6\" align=\"center\">");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>footer page title</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"center\">Home || Products || Services || Login || About Us</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
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
